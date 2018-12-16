package ru.breakchir.Arithmetic;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticLexer {

    private String input;
    private int curPos;
    private ArithmeticToken curToken;
    private Map<ArithmeticToken, Pattern> regex;
    private Pattern patternWS;
    private Matcher m;

    public ArithmeticLexer(String input) {
        this.input = input;
        curPos = 0;
        setRegex();
        patternWS = Pattern.compile("[ \n\r\t]+");
        m = Pattern.compile("").matcher(input);
    }

    private void setRegex() {
        regex = new HashMap<>();
        regex.put(ArithmeticToken.ADD, Pattern.compile("[+]"));
        regex.put(ArithmeticToken.SUB, Pattern.compile("[-]"));
        regex.put(ArithmeticToken.MUL, Pattern.compile("[*]"));
        regex.put(ArithmeticToken.DIV, Pattern.compile("[/]"));
        regex.put(ArithmeticToken.POW, Pattern.compile("\\^"));
        regex.put(ArithmeticToken.OP, Pattern.compile("[(]"));
        regex.put(ArithmeticToken.CP, Pattern.compile("[)]"));
        regex.put(ArithmeticToken.NUM, Pattern.compile("([1-9][0-9]*)|(0)"));
        regex.put(ArithmeticToken.END, Pattern.compile("$"));
    }

    private void skipWhiteSpaces() {
        String text = input.substring(curPos);
        m.usePattern(patternWS);
        m.reset(text);
        if (m.lookingAt()) {
        curPos += m.end();
        }
    }

    private boolean findNextToken() {
        String text = input.substring(curPos);
        for (ArithmeticToken t : ArithmeticToken.values()) {
            m.usePattern(regex.get(t));
            m.reset(text);
            if (m.lookingAt()) {
                curToken = t;
                curPos += m.end();
                return true;
            }
        }
        return false;
    }

    public void nextToken() throws ParseException {
        if (curPos == input.length()) {
            curToken = ArithmeticToken.END;
            return;
        }
        skipWhiteSpaces();
        if (curPos == input.length()) {
            curToken = ArithmeticToken.END;
            return;
        }
        if (!findNextToken()) {
            throw new ParseException("Illegal sequence of characters at", curPos);
        }
    }

    public String getLexeme() {
        return m.group();
    }

    public int getCurPos() {
        return curPos;
    }

    public ArithmeticToken getCurToken() {
        return curToken;
    }

}
