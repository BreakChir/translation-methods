package ru.breakchir;

public class BeginStatement implements Expression{

    private ExpressionList list;
    private int els;
    private int spaceCount;

    public BeginStatement(ExpressionList list, int spaceCount, int els) {
        this.list = list;
        this.spaceCount = spaceCount;
        this.els = els;
    }

    public void append(StringBuilder builder) {
        if (els == 1) {
            builder.append(System.lineSeparator()).append("  ");
        }
        for (int i = 0; i < spaceCount; i++) {
            builder.append("  ");
        }

        builder.append("begin").append(System.lineSeparator());
        list.append(builder);
        for (int i = 0; i < spaceCount; i++) {
            builder.append("  ");
        }
        if (els == 1) {
            builder.append("  ");
        }
        builder.append("end");
        if (els != 2) {
            builder.append(';');
        }
        builder.append(System.lineSeparator());
    }
}
