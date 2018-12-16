package ru.breakchir;

public class Code implements Production {

    String code;

    public Code(String code) {
        this.code = code.substring(1, code.length() - 1);
    }
}
