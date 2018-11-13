package ru.breakchir;

public class StatementIfElse implements Expression {

    private BooleanExpression conditional;
    private Expression left;
    private Expression right;
    private int els;
    private int spaceCount;

    public StatementIfElse(BooleanExpression conditional, Expression left, Expression right,
                           int spaceCount, int els) {
        this.conditional = conditional;
        this.left = left;
        this.right = right;
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
        left.append(builder);
        for (int i = 0; i < spaceCount; i++) {
            builder.append("  ");
        }
        builder.append("else");
        right.append(builder);
    }
}
