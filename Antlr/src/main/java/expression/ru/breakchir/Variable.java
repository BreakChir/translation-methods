package ru.breakchir;

public class Variable implements Argument, ArithmeticExpression, BooleanExpression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public void append(StringBuilder builder) {
        builder.append(name);
    }
}
