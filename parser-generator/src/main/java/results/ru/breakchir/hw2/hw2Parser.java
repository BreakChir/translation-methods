package ru.breakchir.hw2;

import java.text.ParseException;

public class hw2Parser {
    private hw2Lexer lex;

    class X {
        String v;
    }

    class Xp {
        String v;
    }

    class D {
        String v;
    }

    class Dp {
        String v;
    }

    class C {
        String v;
    }

    class Cp {
        String v;
    }

    class U {
        String v;
    }

    X parse(String expr) throws ParseException {
        lex = new hw2Lexer(expr);
        lex.nextToken();
        X p = x();
        if (lex.getCurToken() != hw2Token.END) {
            throw new AssertionError(lex.getCurToken());
        }
        return p;
    }

    private X x() throws ParseException {
        X ret = new X();
        switch (lex.getCurToken()) {
            case OP:
            case NOT:
            case VAR:
            {
                D d = d();
                Xp xp = xp();
                ret.v = d.v + xp.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private Xp xp() throws ParseException {
        Xp ret = new Xp();
        switch (lex.getCurToken()) {
            case OR:
            {
                String OR = consume(hw2Token.OR);
                D d = d();
                Xp xp = xp();
                ret.v = OR + d.v + xp.v;
                return ret;
            }
            case END:
            case CP:
                ret.v = "";
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private D d() throws ParseException {
        D ret = new D();
        switch (lex.getCurToken()) {
            case OP:
            case NOT:
            case VAR:
            {
                C c = c();
                Dp dp = dp();
                ret.v = c.v + dp.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private Dp dp() throws ParseException {
        Dp ret = new Dp();
        switch (lex.getCurToken()) {
            case XOR:
            {
                String XOR = consume(hw2Token.XOR);
                C c = c();
                Dp dp = dp();
                ret.v = XOR + c.v + dp.v;
                return ret;
            }
            case OR:
            case END:
            case CP:
                ret.v = "";
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private C c() throws ParseException {
        C ret = new C();
        switch (lex.getCurToken()) {
            case OP:
            case NOT:
            case VAR:
            {
                U u = u();
                Cp cp = cp();
                ret.v = u.v + cp.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private Cp cp() throws ParseException {
        Cp ret = new Cp();
        switch (lex.getCurToken()) {
            case AND:
            {
                String AND = consume(hw2Token.AND);
                U u = u();
                Cp cp = cp();
                ret.v = AND + u.v + cp.v;
                return ret;
            }
            case OR:
            case XOR:
            case END:
            case CP:
                ret.v = "";
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private U u() throws ParseException {
        U ret = new U();
        switch (lex.getCurToken()) {
            case NOT:
            {
                String NOT = consume(hw2Token.NOT);
                U u = u();
                ret.v = NOT + u.v;
                return ret;
            }
            case VAR:
            {
                String VAR = consume(hw2Token.VAR);
                ret.v = VAR;
                return ret;
            }
            case OP:
            {
                String OP = consume(hw2Token.OP);
                X x = x();
                String CP = consume(hw2Token.CP);
                ret.v = OP + x.v + CP;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private String consume(hw2Token token) throws ParseException {
        if (lex.getCurToken() != token) {
            throw new ParseException("Incorrect token at position: ", lex.getCurPos());
        }
        String lexeme = lex.getLexeme();
        lex.nextToken();
        return lexeme;
    }

}
