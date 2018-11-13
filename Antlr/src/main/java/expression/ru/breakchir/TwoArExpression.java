package ru.breakchir;

public class TwoArExpression implements ArithmeticExpression {

    private ExprToken operation;
    private ArithmeticExpression left;
    private ArithmeticExpression right;

    public TwoArExpression(ExprToken operation, ArithmeticExpression left, ArithmeticExpression right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public void append(StringBuilder builder) {
        builder.append('(');
        left.append(builder);
        builder.append(' ');

        switch (operation) {
            case ADD:
                builder.append('+');
                break;
            case SUB:
                builder.append('-');
                break;
            case MUL:
                builder.append('*');
                break;
            case DIV:
                builder.append('/');
                break;
            case MOD:
                builder.append('%');
                break;
            case POW:
                builder.append("**");
                break;
        }

        builder.append(' ');
        right.append(builder);
        builder.append(')');
    }
}
