package ru.breakchir;

public class Program {

    private ExpressionList list;

    public Program(ExpressionList list) {
        this.list = list;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("begin").append(System.lineSeparator());
        list.append(builder, 0);
        builder.append("end.");
        return builder.toString();
    }
}
