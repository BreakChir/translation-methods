package ru.breakchir.Arithmetic;

import java.text.ParseException;

public class ArithmeticParser {
    private ArithmeticLexer lex;

    class Addsub {
        int v;
        boolean isZero;
    }

    class Addsub_ {
        int v;
    }

    class Muldiv {
        int v;
    }

    class Muldiv_ {
        int v;
    }

    class Pow {
        int v;
    }

    class Pow_ {
        int v;
    }

    class Unary {
        int v;
    }

    Addsub parse(String expr) throws ParseException {
        lex = new ArithmeticLexer(expr);
        lex.nextToken();
        Addsub p = addSub();
        if (lex.getCurToken() != ArithmeticToken.END) {
            throw new AssertionError(lex.getCurToken());
        }
        return p;
    }

    private Addsub addSub() throws ParseException {
        Addsub ret = new Addsub();
        switch (lex.getCurToken()) {
            case OP:
            case NUM:
            {
                Muldiv mulDiv = mulDiv();
                Addsub_ addSub_ = addSub_(mulDiv.v);
                ret.v = addSub_.v;
                ret.isZero = ret.v == 0;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private Addsub_ addSub_(int left) throws ParseException {
        Addsub_ ret = new Addsub_();
        switch (lex.getCurToken()) {
            case ADD:
            {
                String ADD = consume(ArithmeticToken.ADD);
                Muldiv mulDiv = mulDiv();
                int next = left + mulDiv.v;
                Addsub_ addSub_ = addSub_(next);
                ret.v = addSub_.v;
                return ret;
            }
            case SUB:
            {
                String SUB = consume(ArithmeticToken.SUB);
                Muldiv mulDiv = mulDiv();
                int next = left - mulDiv.v;
                Addsub_ addSub_ = addSub_(next);
                ret.v = addSub_.v;
                return ret;
            }
            case END:
            case CP:
                ret.v = left;
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private Muldiv mulDiv() throws ParseException {
        Muldiv ret = new Muldiv();
        switch (lex.getCurToken()) {
            case OP:
            case NUM:
            {
                Pow pow = pow();
                Muldiv_ mulDiv_ = mulDiv_(pow.v);
                ret.v = mulDiv_.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private Muldiv_ mulDiv_(int left) throws ParseException {
        Muldiv_ ret = new Muldiv_();
        switch (lex.getCurToken()) {
            case MUL:
            {
                String MUL = consume(ArithmeticToken.MUL);
                Pow pow = pow();
                Muldiv_ mulDiv_ = mulDiv_(left * pow.v);
                ret.v = mulDiv_.v;
                return ret;
            }
            case DIV:
            {
                String DIV = consume(ArithmeticToken.DIV);
                Pow pow = pow();
                Muldiv_ mulDiv_ = mulDiv_(left / pow.v);
                ret.v = mulDiv_.v;
                return ret;
            }
            case ADD:
            case SUB:
            case END:
            case CP:
                ret.v = left;
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private Pow pow() throws ParseException {
        Pow ret = new Pow();
        switch (lex.getCurToken()) {
            case OP:
            case NUM:
            {
                Unary unary = unary();
                Pow_ pow_ = pow_(unary.v);
                ret.v = pow_.v;
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private Pow_ pow_(int left) throws ParseException {
        Pow_ ret = new Pow_();
        switch (lex.getCurToken()) {
            case POW:
            {
                String POW = consume(ArithmeticToken.POW);
                Unary unary = unary();
                Pow_ pow_ = pow_((int) Math.pow(left, unary.v));
                ret.v = pow_.v;
                return ret;
            }
            case DIV:
            case ADD:
            case SUB:
            case MUL:
            case END:
            case CP:
                ret.v = left;
                return ret;
            default:
                throw new AssertionError();
        }
    }

    private Unary unary() throws ParseException {
        Unary ret = new Unary();
        switch (lex.getCurToken()) {
            case OP:
            {
                String OP = consume(ArithmeticToken.OP);
                Addsub addSub = addSub();
                String CP = consume(ArithmeticToken.CP);
                ret.v = addSub.v;
                return ret;
            }
            case NUM:
            {
                String NUM = consume(ArithmeticToken.NUM);
                ret.v = Integer.valueOf(NUM);
                return ret;
            }
            default:
                throw new AssertionError();
        }
    }

    private String consume(ArithmeticToken token) throws ParseException {
        if (lex.getCurToken() != token) {
            throw new ParseException("Incorrect token at position: ", lex.getCurPos());
        }
        String lexeme = lex.getLexeme();
        lex.nextToken();
        return lexeme;
    }

}
