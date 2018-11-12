package ru.breakchir;

import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    private LexicalAnalyzer lex;

    private Tree X() throws ParseException {
        switch (lex.getCurToken()) {
            case NOT:
            case LPAREN:
            case VAR:
                Tree subD = D();
                Tree subXP = XPrime();
                return new Tree("X", subD, subXP);
            case END:
                return new Tree("X");
            default:
                throw new AssertionError();
        }
    }

    private Tree XPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case OR:
                lex.nextToken();
                Tree subD = D();
                Tree subXP = XPrime();
                return new Tree("X'", new Tree("^"), subD, subXP);
            case RPAREN:
            case END:
                return new Tree("X'");
            default:
                throw new AssertionError(lex.getCurToken());
        }
    }

    private Tree D() throws ParseException {
        switch (lex.getCurToken()) {
            case NOT:
            case LPAREN:
            case VAR:
                Tree subC = C();
                Tree subDP = DPrime();
                return new Tree("D", subC, subDP);
            default:
                throw new AssertionError();
        }
    }

    private Tree DPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case XOR:
                lex.nextToken();
                Tree subC = C();
                Tree subDP = DPrime();
                return new Tree("D'", new Tree("|"), subC, subDP);
            case OR:
            case RPAREN:
            case END:
                return new Tree("D'");
            default:
                throw new AssertionError();
        }
    }

    private Tree C() throws ParseException {
        switch (lex.getCurToken()) {
            case NOT:
            case LPAREN:
            case VAR:
                Tree subU = U();
                Tree subCP = CPrime();
                return new Tree("C", subU, subCP);
            case RPAREN:
            default:
                throw new AssertionError();
        }
    }

    private Tree CPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case AND:
                lex.nextToken();
                Tree subU = U();
                Tree subCP = CPrime();
                return new Tree("C'", new Tree("&"), subU, subCP);
            case OR:
            case XOR:
            case RPAREN:
            case END:
                return new Tree("C'");
            default:
                throw new AssertionError();
        }
    }

    private Tree U() throws ParseException {
        switch (lex.getCurToken()) {
            case NOT:
                lex.nextToken();
                Tree subU = U();
                return new Tree("U", new Tree("!"), subU);
            case LPAREN:
                lex.nextToken();
                Tree subX = X();
                if (lex.getCurToken() != Token.RPAREN) {
                    throw new ParseException(") expected at position", lex.getCurPos());
                }
                lex.nextToken();
                return new Tree("U", new Tree("("), subX, new Tree(")"));
            case VAR:
                int var = lex.getCurChar();
                lex.nextToken();
                return new Tree("U", new Tree(String.valueOf((char) var)));
            default:
                throw new AssertionError();
        }
    }

    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return X();
    }

    Tree parse(String expr) throws ParseException {
        lex = new LexicalAnalyzer(expr);
        lex.nextToken();
        Tree p = X();
        if (lex.getCurToken() != Token.END) {
            throw new AssertionError(lex.getCurToken());
        }
        return p;
    }
}
