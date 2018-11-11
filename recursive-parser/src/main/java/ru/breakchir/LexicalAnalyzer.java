package ru.breakchir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {
    private InputStream is;
    private int curChar;
    private int lastChar;
    private int curPos;
    private Token curToken;

    private void init() throws ParseException  {
        curPos = 0;
        nextChar();
    }

    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        init();
    }

    public LexicalAnalyzer(String expr) throws ParseException {
        this.is = new ByteArrayInputStream(expr.getBytes());
        init();
    }

    private boolean isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            lastChar = curChar;
            curChar = is.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        while (isBlank(curChar)) {
            nextChar();
        }

        if (curChar == '!') {
            curToken = Token.NOT;
        } else if (curChar == '&') {
            curToken = Token.AND;
        } else if (curChar == '|') {
            curToken = Token.OR;
        } else if (curChar == '^') {
            curToken = Token.XOR;
        } else if (curChar == '(') {
            curToken = Token.LPAREN;
        } else if (curChar == ')') {
            curToken = Token.RPAREN;
        } else if (curChar >= 'a' && curChar <= 'z') {
            curToken = Token.VAR;
        } else if (curChar == -1) {
            curToken = Token.END;
        } else {
            throw new ParseException("Illegal character " + (char) curChar, curPos);
        }

        if (curToken != Token.END) {
            nextChar();
        }
    }

    public int getCurChar() {
        return lastChar;
    }

    public int getCurPos() {
        return curPos;
    }

    public Token getCurToken() {
        return curToken;
    }
}
