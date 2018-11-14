package ru.breakchir;

public class Program {

    private ExpressionList list;

    public Program(ExpressionList list) {
        this.list = list;
    }

    public void append(StringBuilder builder) {
        builder.append("begin").append(System.lineSeparator());
        for (Expression expr : list.getList()) {
            expr.append(builder, 0, false, false);
        }
        builder.append("end.");
    }
}
