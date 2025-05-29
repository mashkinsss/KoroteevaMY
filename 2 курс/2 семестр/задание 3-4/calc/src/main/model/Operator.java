package main.model;

import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", 2, (a, b) -> a + b),
    SUBTRACTION("-", 2, (a, b) -> a - b),
    MULTIPLICATION("*", 3, (a, b) -> a * b),
    DIVISION("/", 3, (a, b) -> {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }),
    FLOOR_DIVISION("//", 3, (a, b) -> Math.floor(a / b)),
    EXPONENTIATION("^", 4, Math::pow),
    EXPONENTIATION2("**", 4, Math::pow),
    FACTORIAL("!", 6, (a, b) -> factorial(a)),
    EXP("exp", 5, (a, b) -> Math.exp(a)),
    LOG("log", 5, (a, b) -> Math.log(a)/Math.log(2));

    private final String symbol;
    private final int precedence;
    private final BiFunction<Double, Double, Double> operation;

    Operator(String symbol, int precedence, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.operation = operation;
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equalsIgnoreCase(symbol)) return op;
        }
        return null;
    }

    public double apply(double a, double b) { return operation.apply(a, b); }
    public int getPrecedence() { return precedence; }
    public String getSymbol() { return symbol; }

    private static double factorial(double a) {
        if (a < 0 || a != (int) a) throw new ArithmeticException("Invalid factorial");
        int n = (int) a;
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}