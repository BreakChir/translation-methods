package ru.breakchir.hw2;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw2Lexer {

    private String input;
    private int curPos;
    private hw2Token curToken;
    private Map<hw2Token, Pattern> regex;
    private Pattern patternWS;
    private Matcher m;

    public hw2Lexer(String input) {
        this.input = input;
        curPos = 0;
        setRegex();
        patternWS = Pattern.compile("[ \n\t\r]+");
        m = Pattern.compile("").matcher(input);
    }

    private void setRegex() {
        regex = new HashMap<>();
        regex.put(hw2Token.AND, Pattern.compile("[&]"));
        regex.put(hw2Token.XOR, Pattern.compile("\\^"));
        regex.put(hw2Token.OR, Pattern.compile("[|]"));
        regex.put(hw2Token.OP, Pattern.compile("[(]"));
        regex.put(hw2Token.CP, Pattern.compile("[)]"));
        regex.put(hw2Token.NOT, Pattern.compile("[!]"));
        regex.put(hw2Token.VAR, Pattern.compile("[a-z]+"));
        regex.put(hw2Token.END, Pattern.compile("$"));
    }

    private void skipWhiteSpaces() {
        m.usePattern(patternWS);
        m.region(curPos, input.length());
        if (m.lookingAt()) {
            curPos += m.end() - m.start();
        }
    }

    private boolean findNextToken() {
        for (hw2Token t : hw2Token.values()) {
            m.usePattern(regex.get(t));
            m.region(curPos, input.length());
            if (m.lookingAt()) {
                curToken = t;
                curPos += m.end() - m.start();
                return true;
            }
        }
        return false;
    }

    public void nextToken() throws ParseException {
        if (curPos == input.length()) {
            curToken = hw2Token.END;
            return;
        }
        skipWhiteSpaces();
        if (curPos == input.length()) {
            curToken = hw2Token.END;
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

    public hw2Token getCurToken() {
        return curToken;
    }

}
