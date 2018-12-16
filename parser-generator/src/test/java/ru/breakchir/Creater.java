package ru.breakchir;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Creater {
    public static void main(String[] args) throws IOException {
        create("Arithmetic");
        create("hw2");
    }

    private static void create(String grammarName) throws IOException {
        String dirIn = "grammars/" + grammarName;
        Path path = Paths.get("src/main/java/results/ru/breakchir", grammarName);
        Path dir;
        if (Files.notExists(path)) {
            dir = Files.createDirectory(path);
        } else {
            dir = path;
        }
        String dirOut = dir.toString();
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(dirIn));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        ParsedGrammar grammar = parser.start().v;
        boolean isCorrect = grammar.buildFirstFollow();
        if (isCorrect) {
            TokenGenerator tokenGenerator = new TokenGenerator(dirOut, grammarName, grammar);
            tokenGenerator.printFile();
            LexerGenerator lexerGenerator = new LexerGenerator(dirOut, grammarName, grammar);
            lexerGenerator.printFile();
            ParserGenerator parserGenerator = new ParserGenerator(dirOut, grammarName, grammar);
            parserGenerator.printFile();
        } else {
            System.out.println("Input grammar is not LL(1)-Grammar");
        }
    }
}
