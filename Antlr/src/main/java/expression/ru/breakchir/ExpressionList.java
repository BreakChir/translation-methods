package ru.breakchir;

import java.util.List;

public class ExpressionList {

    private List<Expression> expressions;

    public ExpressionList(List<Expression> list) {
        this.expressions = list;
    }

    public void append(StringBuilder builder, int level) {
        for (Expression expr : expressions) {
            expr.append(builder, level, false, false);
        }
    }
}
