package ru.breakchir;

public class Print implements Expression {

    private Argument arg;
    private int spaceCount;
    private int els;

    public Print(Argument arg, int spaceCount, int els) {
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
        builder.append("writeln(");
        arg.append(builder);
        builder.append(')');
        if (els != 2) {
            builder.append(';');
        }
        builder.append(System.lineSeparator());
    }
}
