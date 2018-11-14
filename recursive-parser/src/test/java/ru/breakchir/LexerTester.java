package ru.breakchir;

import org.junit.Test;

public class LexerTester {

    @Test
    public void test1() throws Exception {
        String test = "!a & (a | (c ^ !a))";
        Token[] tokens = {Token.NOT, Token.VAR, Token.AND, Token.LPAREN, Token.VAR, Token.OR,
                Token.LPAREN, Token.VAR, Token.XOR, Token.NOT, Token.VAR, Token.RPAREN, Token.RPAREN, Token.END};
        runTest(test, tokens);
    }

    @Test
    public void test2() throws Exception {
        String test = "!(a) ^ b";
        Token[] tokens = {Token.NOT, Token.LPAREN, Token.VAR, Token.RPAREN, Token.XOR, Token.VAR, Token.END};
        runTest(test, tokens);
    }

    @Test
    public void testEmpty() throws Exception {
        String test = "";
        Token[] tokens = {Token.END};
        runTest(test, tokens);
    }

    private void runTest(String testString, Token[] tokens) throws Exception {
        LexicalAnalyzer lexer = new LexicalAnalyzer(testString);
        for (int i = 0; i < tokens.length; i++) {
            lexer.nextToken();
            Token token = lexer.getCurToken();
            if (token != tokens[i])
                throw new Exception("Incorrect token");
        }
    }
}