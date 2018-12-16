package ru.breakchir;

import java.util.List;

public class TokenGenerator extends ClassGenerator {

    public TokenGenerator(String dir, String name, ParsedGrammar grammar) {
        super(dir, name, name + "Token.java", grammar);
    }

    void printImports() {
    }

    void printClass() {
        printName();
        printTokens();
        printEnd();
    }

    private void printName() {
        printLine(0, "public enum ", tokenName, " {");
    }

    private void printEnd() {
        printLine(0, "}");
    }

    private void printTokens() {
        List<TermRule> termRules = grammar.termRules;
        for (TermRule rule : termRules) {
            printLine(1, rule.name, ",");
        }
        printLine(1, "END");
    }
}
