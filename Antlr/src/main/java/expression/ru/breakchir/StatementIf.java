package ru.breakchir;

public class StatementIf implements Expression {

    private BooleanExpression conditional;
    private Expression arg;
    private int els;
    private int spaceCount;

    public StatementIf(BooleanExpression conditional, Expression arg, int spaceCount, int els) {
        this.conditional = conditional;
        this.arg = arg;
        this.spaceCount = spaceCount;
        this.els = els;
    }

    public void append(StringBuilder builder) {
        if (els == 1) {
            builder.append(' ');
        } else {
            for (int i = 0; i < spaceCount; i++) {
                builder.append("  ");
            }
        }

        builder.append("if ");
        conditional.append(builder);
        builder.append(" then").append(System.lineSeparator());
        arg.append(builder);
    }
}
