package ru.breakchir;

public interface Expression {
    void append(StringBuilder builder, int level, boolean willElse, boolean isElse);
}
