package ru.breakchir;

public class Assignment implements Expression {

    private Argument arg;
    private String var;

    public Assignment(String var, Argument arg) {
        this.var = var;
        this.arg = arg;
    }

    public void append(StringBuilder builder, int level, boolean willElse, boolean isElse) {
        if (isElse) {
            builder.append(System.lineSeparator());
        }
        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }
        builder.append(var);
        builder.append(" = ");
        arg.append(builder);
        if (!willElse) {
            builder.append(';');
        }
        builder.append(System.lineSeparator());
    }
}
