package ru.breakchir;

public class StatementIfElse implements Expression {

    private BooleanExpression conditional;
    private Expression left;
    private Expression right;

    public StatementIfElse(BooleanExpression conditional, Expression left, Expression right) {
        this.conditional = conditional;
        this.left = left;
        this.right = right;
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
        left.append(builder, level + 1, true, false);
        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }
        builder.append("else");
        right.append(builder, right instanceof StatementIf || right instanceof StatementIfElse ? level : level + 1,
                true, true);
    }
}
