package main.model;

import java.util.*;

public class ExpressionEvaluator {
    public double evaluate(String expression) throws SyntaxException, ArithmeticException {
        List<Token> tokens = parse(expression);
        validateSyntax(tokens);
        List<Token> postfix = shuntingYard(tokens);
        return evaluatePostfix(postfix);
    }

    private List<Token> parse(String expr) throws SyntaxException {
        List<Token> tokens = new ArrayList<>();
        int pos = 0;
        while (pos < expr.length()) {
            char c = expr.charAt(pos);
            if (Character.isDigit(c) || c == '.' || (c == '-' && (pos == 0 || isOperatorOrParen(expr.charAt(pos - 1))))) {
                StringBuilder num = new StringBuilder();
                num.append(c);
                pos++;
                while (pos < expr.length() && (Character.isDigit(expr.charAt(pos)) || expr.charAt(pos) == '.')) {
                    num.append(expr.charAt(pos++));
                }
                try {
                    tokens.add(new Token(Double.parseDouble(num.toString())));
                } catch (NumberFormatException e) {
                    throw new SyntaxException("Invalid number: " + num);
                }
            } else if (c == '(') {
                tokens.add(new Token(Token.Type.PAREN_OPEN));
                pos++;
            } else if (c == ')') {
                tokens.add(new Token(Token.Type.PAREN_CLOSE));
                pos++;
            } else if (pos + 3 <= expr.length() && expr.startsWith("exp(", pos)) {
                tokens.add(new Token(Operator.EXP));
                tokens.add(new Token(Token.Type.PAREN_OPEN));
                pos += 4;
            } else if (pos + 4 <= expr.length() && expr.startsWith("log(", pos)) {
                tokens.add(new Token(Operator.LOG));
                tokens.add(new Token(Token.Type.PAREN_OPEN));
                pos += 4;
            } else {
                String symbol = parseOperator(expr, pos);
                Operator op = Operator.fromSymbol(symbol);
                if (op == null) throw new SyntaxException("Unknown operator: " + symbol);
                tokens.add(new Token(op));
                pos += symbol.length();
            }
        }
        return tokens;
    }

    private String parseOperator(String expr, int pos) {
        if (pos + 1 < expr.length()) {
            String twoChar = expr.substring(pos, pos + 2);
            if (Operator.fromSymbol(twoChar) != null) return twoChar;
        }
        return expr.substring(pos, pos + 1);
    }

    private boolean isOperatorOrParen(char c) {
        return "+-*/()^!".indexOf(c) != -1;
    }

    private void validateSyntax(List<Token> tokens) throws SyntaxException {
        if (tokens.size() > 15) throw new SyntaxException("Max 15 elements allowed");
        int balance = 0;
        for (Token t : tokens) {
            if (t.getType() == Token.Type.PAREN_OPEN) balance++;
            if (t.getType() == Token.Type.PAREN_CLOSE) balance--;
            if (balance < 0) throw new SyntaxException("Mismatched parentheses");
        }
        if (balance != 0) throw new SyntaxException("Mismatched parentheses");
    }

    private List<Token> shuntingYard(List<Token> tokens) {
        List<Token> output = new ArrayList<>();
        Deque<Token> stack = new ArrayDeque<>();

        for (Token token : tokens) {
            switch (token.getType()) {
                case NUMBER:
                    output.add(token);
                    break;
                case OPERATOR:
                    while (!stack.isEmpty() && stack.peek().getType() == Token.Type.OPERATOR &&
                            stack.peek().getOperatorValue().getPrecedence() >= token.getOperatorValue().getPrecedence()) {
                        output.add(stack.pop());
                    }
                    stack.push(token);
                    break;
                case PAREN_OPEN:
                    stack.push(token);
                    break;
                case PAREN_CLOSE:
                    while (!stack.isEmpty() && stack.peek().getType() != Token.Type.PAREN_OPEN) {
                        output.add(stack.pop());
                    }
                    stack.pop();
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    private double evaluatePostfix(List<Token> postfix) throws ArithmeticException {
        Deque<Double> stack = new ArrayDeque<>();
        for (Token token : postfix) {
            if (token.getType() == Token.Type.NUMBER) {
                stack.push(token.getNumberValue());
            } else {
                Operator op = token.getOperatorValue();
                if (op == Operator.FACTORIAL || op == Operator.EXP || op == Operator.LOG) {
                    double a = stack.pop();
                    stack.push(op.apply(a, 0.0));
                } else {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(op.apply(a, b));
                }
            }
        }
        return stack.pop();
    }
}