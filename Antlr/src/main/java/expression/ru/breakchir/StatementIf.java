package ru.breakchir;

public class StatementIf implements Expression {

    private BooleanExpression conditional;
    private Expression arg;

    public StatementIf(BooleanExpression conditional, Expression arg) {
        this.conditional = conditional;
        this.arg = arg;
    }

    public void append(StringBuilder builder, int level, boolean willElse, boolean isElse) {
        if (isElse) {
            builder.append(' ');
        } else {
            for (int i = 0; i < level; i++) {
                builder.append("  ");
            }
        }

        builder.append("if (");
        conditional.append(builder);
        builder.append(") then").append(System.lineSeparator());
        arg.append(builder, level + 1, false, false);
    }
}
