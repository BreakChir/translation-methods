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
    public void testIf() {
        String test = "if true if true if true if true if true if true if true = y 6= x 6 if false = z 6 = a 6 = b 6";
        runTest(test, true);
    }

    @Test
    public void testMainBody() {
        String test = "= x 5 = x 6 print 5 if < 4 5 print 5 print 4 = a 8 = a 9 begin = b -1 print b";
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
        for (int i = 0; i < 100; i++) {
            PrefixProgramGenerator generator = new PrefixProgramGenerator(10, (i + 2) * 100);
            String test = generator.generateProgram();
            runTest(test, true);
        }
    }

    private void runTest(String test, boolean isPrint)  {
        CodeLexer lexer = new CodeLexer(CharStreams.fromString(test));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeParser parser = new CodeParser(tokens);
        Program program = parser.start().v;
        if (isPrint) {
            StringBuilder builder = new StringBuilder();
            program.append(builder);
            System.out.println(test);
            System.out.println(builder.toString());
            System.out.println();
        }
    }
}