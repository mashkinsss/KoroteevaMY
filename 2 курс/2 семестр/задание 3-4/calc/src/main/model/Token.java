package main.model;

public class Token {
    public enum Type { NUMBER, OPERATOR, PAREN_OPEN, PAREN_CLOSE }
    private final Type type;
    private final Double numberValue;
    private final Operator operatorValue;

    public Token(Double number) {
        this.type = Type.NUMBER;
        this.numberValue = number;
        this.operatorValue = null;
    }

    public Token(Operator operator) {
        this.type = Type.OPERATOR;
        this.operatorValue = operator;
        this.numberValue = null;
    }

    public Token(Type type) {
        this.type = type;
        this.numberValue = null;
        this.operatorValue = null;
    }

    public Type getType() { return type; }
    public Double getNumberValue() { return numberValue; }
    public Operator getOperatorValue() { return operatorValue; }
}