package ru.breakchir;

public class BoolValue implements BooleanExpression {

    private String name;

    public BoolValue(String name) {
        this.name = name;
    }

    @Override
    public void append(StringBuilder builder) {
        builder.append(name);
    }
}
