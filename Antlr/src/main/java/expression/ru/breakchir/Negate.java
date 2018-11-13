package ru.breakchir;

public class Negate implements BooleanExpression {

    private BooleanExpression arg;

    public Negate(BooleanExpression arg) {
        this.arg = arg;
    }

    public void append(StringBuilder builder) {
        builder.append('!');
        arg.append(builder);
    }
}
