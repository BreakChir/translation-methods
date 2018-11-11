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
                // D
                Tree subD = D();
                // X'
                Tree subXP = XPrime();
                return new Tree("X", subD, subXP);
            case RPAREN:
            case END:
                // eps
                return new Tree("X");
            default:
                throw new AssertionError();
        }
    }

    private Tree XPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case XOR:
                // ^
                lex.nextToken();
                // X
                Tree subX = X();
                return new Tree("X'", new Tree("^"), subX);
            case RPAREN:
            case END:
                // eps
                return new Tree("X'");
            default:
                throw new AssertionError();
        }
    }

    private Tree D() throws ParseException {
        switch (lex.getCurToken()) {
            case NOT:
            case LPAREN:
            case VAR:
                // D
                Tree subC = C();
                // X'
                Tree subDP = DPrime();
                return new Tree("D", subC, subDP);
            case XOR:
            case RPAREN:
            case END:
                // eps
                return new Tree("D");
            default:
                throw new AssertionError();
        }
    }

    private Tree DPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case OR:
                // |
                lex.nextToken();
                // D
                Tree subD = D();
                return new Tree("D'", new Tree("|"), subD);
            case XOR:
            case RPAREN:
            case END:
                // eps
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
                // U
                Tree subU = U();
                // C'
                Tree subCP = CPrime();
                return new Tree("C", subU, subCP);
            case OR:
            case XOR:
            case RPAREN:
            case END:
                // eps
                return new Tree("C");
            default:
                throw new AssertionError();
        }
    }

    private Tree CPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case AND:
                // &
                lex.nextToken();
                // C
                Tree subC = C();
                return new Tree("C'", new Tree("&"), subC);
            case OR:
            case XOR:
            case RPAREN:
            case END:
                // eps
                return new Tree("C'");
            default:
                throw new AssertionError();
        }
    }

    private Tree U() throws ParseException {
        switch (lex.getCurToken()) {
            case NOT:
                // !
                lex.nextToken();
                // U
                Tree subU = U();
                return new Tree("U", new Tree("!"), subU);
            case LPAREN:
                // (
                lex.nextToken();
                // X
                Tree subX = X();
                // )
                if (lex.getCurToken() != Token.RPAREN) {
                    throw new ParseException(") expected at position", lex.getCurPos());
                }
                lex.nextToken();
                return new Tree("U", new Tree("("), subX, new Tree(")"));
            case VAR:
                // [a-z]
                int var = lex.getCurChar();
                lex.nextToken();
                return new Tree("U", new Tree(String.valueOf((char) var)));
            case AND:
            case OR:
            case XOR:
            case RPAREN:
            case END:
                // eps
                return new Tree("U");
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
        return X();
    }
}
