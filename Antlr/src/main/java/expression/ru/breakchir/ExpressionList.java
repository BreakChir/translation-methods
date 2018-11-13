package ru.breakchir;

import java.util.List;

public class ExpressionList {

    private List<Expression> expressions;

    public ExpressionList(List<Expression> list) {
        this.expressions = list;
    }

    public List<Expression> getList() {
        return expressions;
    }

    public void append(StringBuilder builder) {
        for (Expression expr : expressions) {
            expr.append(builder);
        }
    }
}
