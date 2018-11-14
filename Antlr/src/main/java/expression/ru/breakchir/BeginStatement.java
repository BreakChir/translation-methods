package ru.breakchir;

public class BeginStatement implements Expression{

    private ExpressionList list;

    public BeginStatement(ExpressionList list) {
        this.list = list;
    }

    public void append(StringBuilder builder, int level, boolean willElse, boolean isElse) {
        if (isElse) {
            builder.append(System.lineSeparator());
        }
        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }

        builder.append("begin").append(System.lineSeparator());
        list.append(builder, level + 1);
        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }
        builder.append("end");
        if (!willElse) {
            builder.append(';');
        }
        builder.append(System.lineSeparator());
    }
}
