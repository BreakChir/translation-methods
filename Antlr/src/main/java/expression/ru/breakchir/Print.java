package ru.breakchir;

public class Print implements Expression {

    private Argument arg;

    public Print(Argument arg) {
        this.arg = arg;
    }

    public void append(StringBuilder builder, int level, boolean willElse, boolean isElse) {
        if (isElse) {
            builder.append(System.lineSeparator());
        }
        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }
        builder.append("writeln(");
        arg.append(builder);
        builder.append(')');
        if (!willElse) {
            builder.append(';');
        }
        builder.append(System.lineSeparator());
    }
}
