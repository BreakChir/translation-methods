package ru.breakchir;

public class Assignment implements Expression {

    private Argument arg;
    private String var;
    private int spaceCount;
    private int els;

    public Assignment(String var, Argument arg, int spaceCount, int els) {
        this.var = var;
        this.arg = arg;
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
        builder.append(var);
        builder.append(" = ");
        arg.append(builder);
        if (els != 2) {
            builder.append(';');
        }
        builder.append(System.lineSeparator());
    }
}
