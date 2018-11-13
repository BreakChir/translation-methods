package ru.breakchir;

public class TwoCmpArExpression implements BooleanExpression {

    private ExprToken operation;
    private ArithmeticExpression left;
    private ArithmeticExpression right;

    public TwoCmpArExpression(ExprToken operation, ArithmeticExpression left, ArithmeticExpression right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public void append(StringBuilder builder) {
        builder.append('(');
        left.append(builder);
        builder.append(' ');

        switch (operation) {
            case LT:
                builder.append('<');
                break;
            case GT:
                builder.append('>');
                break;
            case LTEQ:
                builder.append("<=");
                break;
            case GTEQ:
                builder.append(">=");
                break;
            case EQ:
                builder.append("==");
                break;
            case NQ:
                builder.append("!=");
        }

        builder.append(' ');
        right.append(builder);
        builder.append(')');
    }
}
