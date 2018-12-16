package ru.breakchir;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ClassGenerator {
    String packageName;
    String tokenName;
    String lexerName;
    String parserName;
    ParsedGrammar grammar;
    PrintWriter out;
    final static String EOLN = System.lineSeparator();
    final static String TAB = "    ";

    public ClassGenerator(String dir, String grammarName, String fileName, ParsedGrammar grammar) {
        try {
            out = new PrintWriter(new File(dir, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.packageName = "ru.breakchir." + grammarName;
        this.tokenName = grammarName + "Token";
        this.lexerName = grammarName + "Lexer";
        this.parserName = grammarName + "Parser";
        this.grammar = grammar;
    }

    public void printFile() {
        printPackage();
        printImports();
        printClass();
        out.close();
    }

    void printPackage() {
        printLine(0, "package ", packageName, ";");
        out.write(EOLN);
    }

    abstract void printImports();

    abstract void printClass();

    void printLine(int tabCount, String... strings) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tabCount; i++) {
            builder.append(TAB);
        }
        for (String str : strings) {
            builder.append(str);
        }
        builder.append(EOLN);
        out.write(builder.toString());
    }
}
