package ru.breakchir;

public class Number implements Argument, ArithmeticExpression {

    private String name;

    public Number(String name) {
        this.name = name;
    }

    public void append(StringBuilder builder) {
        builder.append(name);
    }
}
