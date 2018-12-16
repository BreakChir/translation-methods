package ru.breakchir;

public class LexerGenerator extends ClassGenerator {

    LexerGenerator(String dir, String name, ParsedGrammar grammar) {
        super(dir, name, name + "Lexer.java", grammar);
    }

    void printImports() {
        printLine(0, "import java.text.ParseException;");
        printLine(0, "import java.util.HashMap;");
        printLine(0, "import java.util.Map;");
        printLine(0, "import java.util.regex.Matcher;");
        printLine(0, "import java.util.regex.Pattern;");
        out.write(EOLN);
    }

    void printClass() {
        printName();
        printFields();
        printConstructors();
        printMethods();
        printEnd();
    }

    private void printName() {
        printLine(0, "public class ", lexerName, " {", EOLN);
    }

    private void printEnd() {
        out.write('}' + EOLN);
    }

    private void printFields() {
        printLine(1, "private String input;");
        printLine(1, "private int curPos;");
        printLine(1, "private ", tokenName, " curToken;");
        printLine(1, "private Map<", tokenName, ", Pattern> regex;");
        if (grammar.WS != null)
            printLine(1, "private Pattern patternWS;");
        printLine(1, "private Matcher m;");
        out.write(EOLN);
    }

    private void printConstructors() {
        printLine(1, "public ", lexerName, "(String input) {");
        printLine(2, "this.input = input;");
        printLine(2, "curPos = 0;");
        printLine(2, "setRegex();");

        if (grammar.WS != null)
            printLine(2, "patternWS = Pattern.compile(", grammar.WS, ");");
        printLine(2, "m = Pattern.compile(\"\").matcher(input);");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethods() {
        printMethodSetRegex();
        if (grammar.WS != null)
            printMethodSkipWhiteSpaces();
        printMethodFindNextToken();
        printMethodNextToken();
        printMethodGetLexeme();
        printMethodGetCurPos();
        printMethodGetCurToken();
    }

    private void printMethodSetRegex() {
        printLine(1, "private void setRegex() {");
        printLine(2, "regex = new HashMap<>();");
        for (TermRule rule : grammar.termRules) {
            StringBuilder builder = new StringBuilder();
            builder.append("regex.put(")
                    .append(tokenName).append('.').append(rule.name)
                    .append(", Pattern.compile(");

            if (rule.isRegex)
                builder.append(rule.value);
            else {
                String value = rule.value;
                builder.append('\"');
                for (int i = 1; i < value.length() - 1; i++)
                    if (value.charAt(i) == '^' || value.charAt(i) == '$')
                        builder.append("\\\\").append(value.charAt(i));
                    else
                        builder.append('[').append(value.charAt(i)).append(']');
                builder.append('\"');
            }
            builder.append("));");
            printLine(2, builder.toString());
        }
        printLine(2, "regex.put(", tokenName, ".END, Pattern.compile(\"$\"));");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodSkipWhiteSpaces() {
        printLine(1, "private void skipWhiteSpaces() {");
        printLine(2, "m.usePattern(patternWS);");
        printLine(2, "m.region(curPos, input.length());");
        printLine(2, "if (m.lookingAt()) {");
        printLine(3, "curPos += m.end() - m.start();");
        printLine(2, "}");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodFindNextToken() {
        printLine(1, "private boolean findNextToken() {");
        printLine(2, "for (", tokenName, " t : ", tokenName, ".values()) {");
        printLine(3, "m.usePattern(regex.get(t));");
        printLine(3, "m.region(curPos, input.length());");
        printLine(3, "if (m.lookingAt()) {");
        printLine(4, "curToken = t;");
        printLine(4, "curPos += m.end() - m.start();");
        printLine(4, "return true;");
        printLine(3, "}");
        printLine(2, "}");
        printLine(2, "return false;");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodNextToken() {
        printLine(1, "public void nextToken() throws ParseException {");
        printLine(2, "if (curPos == input.length()) {");
        printLine(3, "curToken = ", tokenName, ".END;");
        printLine(3, "return;");
        printLine(2, "}");

        if (grammar.WS != null)
            printLine(2, "skipWhiteSpaces();");

        printLine(2, "if (curPos == input.length()) {");
        printLine(3, "curToken = ", tokenName, ".END;");
        printLine(3, "return;");
        printLine(2, "}");
        printLine(2, "if (!findNextToken()) {");
        printLine(3, "throw new ParseException(\"Illegal sequence of characters at\", curPos);");
        printLine(2, "}");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodGetLexeme() {
        printLine(1, "public String getLexeme() {");
        printLine(2, "return m.group();");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodGetCurPos() {
        printLine(1, "public int getCurPos() {");
        printLine(2, "return curPos;");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodGetCurToken() {
        printLine(1, "public ", tokenName, " getCurToken() {");
        printLine(2, "return curToken;");
        printLine(1, "}");
        out.write(EOLN);
    }
}
