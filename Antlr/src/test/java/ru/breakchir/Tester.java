package ru.breakchir;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.junit.Test;

public class Tester {
    @Test
    public void testSample() {
        String test = "if > 2 3 print 3 if > 4 - 7 2 print + 3 4";
        runTest(test, true);
    }

    @Test
    public void testSimple() {
        String test = "if true = x 3 if true = x 4 if true = x 5 = x 6";
        runTest(test, true);
    }

    @Test
    public void randomTestNum() {
        for (int i = 0; i < 100; i++) {
            PrefixNumGenerator generator = new PrefixNumGenerator((i + 1) * 10);
            String test = "= a " + generator.generateNum();
            runTest(test, false);
        }
    }

    @Test
    public void randomTestBool() {
        for (int i = 0; i < 100; i++) {
            PrefixBoolGenerator generator = new PrefixBoolGenerator((i + 1) * 10);
            String test = "= a " + generator.generateBool();
            runTest(test, false);
        }
    }

    @Test
    public void randomTestProgram() {
        for (int i = 0; i < 5; i++) {
            PrefixProgramGenerator generator = new PrefixProgramGenerator((i + 1) * 10);
            String test = generator.generateProgram();
            runTest(test, false);
        }
    }

    private void runTest(String test, boolean isPrint)  {
        CodeLexer lexer = new CodeLexer(CharStreams.fromString(test));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeParser parser = new CodeParser(tokens);
        String program = parser.start().v;
        if (isPrint) {
            System.out.println(test);
            System.out.println(program);
            System.out.println();
        }
    }
}