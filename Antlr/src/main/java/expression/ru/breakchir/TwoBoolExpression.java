package ru.breakchir;

public class TwoBoolExpression implements BooleanExpression {

    private ExprToken operation;
    private BooleanExpression left;
    private BooleanExpression right;

    public TwoBoolExpression(ExprToken operation, BooleanExpression left, BooleanExpression right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public void append(StringBuilder builder) {
        builder.append('(');
        left.append(builder);
        builder.append(' ');

        switch (operation) {
            case AND:
                builder.append(" && ");
                break;
            case XOR:
                builder.append(" ^ ");
                break;
            case OR:
                builder.append(" || ");
                break;
        }

        builder.append(' ');
        right.append(builder);
        builder.append(')');
    }
}
