package ru.breakchir;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserGenerator extends ClassGenerator {

    public ParserGenerator(String dir, String name, ParsedGrammar grammar) {
        super(dir, name, name + "Parser.java", grammar);
    }

    void printImports() {
        printLine(0, "import java.text.ParseException;");
        out.write(EOLN);
    }

    void printClass() {
        printName();
        printFields();
        printReturnClasses();
        printMethodParse();
        printNTermMethods();
        printMethodConsume();
        printEnd();
    }

    private void printName() {
        printLine(0, "public class ", parserName, " {");
    }

    private void printEnd() {
        printLine(0, "}");
    }

    private void printFields() {
        printLine(1, "private ", lexerName, " lex;");
        out.write(EOLN);
    }

    private void printReturnClasses() {
        for (NTermRule rule : grammar.ntermRules) {
            if (rule.retList == null) continue;
            printLine(1, "class ", rule.getRetType(), " {");
            for (Argument ret : rule.retList) {
                printLine(2, ret.type, " ", ret.name, ";");
            }
            printLine(1, "}");
            out.write(EOLN);
        }
    }

    private void printMethodParse() {
        String type = grammar.ntermToType.get(grammar.startNT);
        printLine(1, type, " parse(String expr) throws ParseException {");
        printLine(2, "lex = new ", lexerName, "(expr);");
        printLine(2, "lex.nextToken();");
        printLine(2, (!type.equals("void") ? type + " p = " : ""), grammar.startNT, "();");
        printLine(2, "if (lex.getCurToken() != ", tokenName, ".END) {");
        printLine(3, "throw new AssertionError(lex.getCurToken());");
        printLine(2, "}");

        if (!type.equals("void"))
            printLine(2, "return p;");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printNTermMethods() {
        List<NTermRule> rules = grammar.ntermRules;
        for (NTermRule rule : rules) {
            beginNTermMethod(rule);
            if (firstCaseNTermMethod(rule))
                followCaseNTermMethod(rule);
            endNTermMethod();
        }
    }

    private void beginNTermMethod(NTermRule rule) {
        StringBuilder builder = new StringBuilder();
        builder.append(TAB).append("private ")
                .append(rule.getRetType())
                .append(' ')
                .append(rule.name)
                .append('(');

        List<Argument> argList = rule.argList;
        if (argList != null) {
            for (int i = 0; i < argList.size(); i++) {
                builder.append(argList.get(i).type)
                        .append(' ')
                        .append(argList.get(i).name);
                if (i != argList.size() - 1)
                    builder.append(", ");
            }
        }

        builder.append(") throws ParseException {")
                .append(EOLN);
        out.write(builder.toString());
        if (!rule.getRetType().equals("void"))
            printLine(2, rule.getRetType(), " ret = new ", rule.getRetType(), "();");
        printLine(2, "switch (lex.getCurToken()) {");
    }

    private boolean firstCaseNTermMethod(NTermRule rule) {
        boolean isHaveEps = false;
        label:
        for (List<Production> prodList : rule.rules) {
            for (String s : grammar.getFirstProdList(prodList)) {
                if (s.equals("EPS")) {
                    isHaveEps = true;
                    continue label;
                } else {
                    printLine(3, "case ", s, ":");
                }
            }
            caseBody(rule, prodList);
        }
        return isHaveEps;
    }

    private String substitute(String code) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            builder.append(code.charAt(i) == '$' ? "ret." : code.charAt(i));
        }
        return builder.toString();
    }

    private void caseBody(NTermRule rule, List<Production> prodList) {
        Set<String> isHaveVar = new HashSet<>();
        printLine(3, "{");
        for (Production prod : prodList) {
            if (prod instanceof Code) {
                printLine(4, substitute(((Code) prod).code));
            } else if (prod instanceof Term) {
                String name = ((Term) prod).name;
                StringBuilder builder = new StringBuilder();

                if (!isHaveVar.contains(name)) {
                    isHaveVar.add(name);
                    builder.append("String ");
                }
                builder.append(name).append(" = consume(")
                        .append(tokenName)
                        .append('.')
                        .append(name)
                        .append(");");

                printLine(4, builder.toString());
            } else {
                String name = ((NTerm) prod).getName();
                StringBuilder builder = new StringBuilder();
                String type = grammar.ntermToType.get(name);
                if (!type.equals("void")) {
                    if (!isHaveVar.contains(name)) {
                        isHaveVar.add(name);
                        builder.append(type)
                                .append(' ');
                    }
                    builder.append(name)
                            .append(" = ");
                }

                builder.append(name)
                        .append('(');
                List<String> parameters = ((NTerm) prod).getParameters();
                for (int i = 0; i < parameters.size(); i++) {
                    builder.append(parameters.get(i));
                    if (i != parameters.size() - 1)
                        builder.append(", ");

                }

                builder.append(");");
                printLine(4, builder.toString());
            }
        }
        printLine(4, "return", (!rule.getRetType().equals("void") ? " ret" : ""), ";");
        printLine(3, "}");
    }

    private void followCaseNTermMethod(NTermRule rule) {
        if (grammar.getFollow(rule.name).isEmpty()) return;
        for (String s : grammar.getFollow(rule.name)) {
            printLine(3, "case ", s, ":");
        }
        for (List<Production> prodList : rule.rules) {
            boolean isHaveEps = false;
            for (String s : grammar.getFirstProdList(prodList)) {
                if (s.equals("EPS")) {
                    isHaveEps = true;
                    break;
                }
            }
            if (isHaveEps) {
                for (Production prod : prodList) {
                    if (prod instanceof Code) {
                        printLine(4, substitute(((Code) prod).code));
                    }
                }
                printLine(4, "return", (!rule.getRetType().equals("void") ? " ret" : ""), ";");
            }
        }
    }

    private void endNTermMethod() {
        printLine(3, "default:");
        printLine(4, "throw new AssertionError();");
        printLine(2, "}");
        printLine(1, "}");
        out.write(EOLN);
    }

    private void printMethodConsume() {
        printLine(1, "private String consume(", tokenName, " token) throws ParseException {");
        printLine(2, "if (lex.getCurToken() != token) {");
        printLine(3, "throw new ParseException(\"Incorrect token at position: \", lex.getCurPos());");
        printLine(2, "}");
        printLine(2, "String lexeme = lex.getLexeme();");
        printLine(2, "lex.nextToken();");
        printLine(2, "return lexeme;");
        printLine(1, "}");
        out.write(EOLN);
    }
}
