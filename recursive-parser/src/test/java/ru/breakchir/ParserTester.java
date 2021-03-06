package ru.breakchir;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

public class ParserTester {
    private Parser parser = new Parser();
    private TreePainter painter = new TreePainter();
    private Cleaner cleaner = new Cleaner();

    @Test
    public void testSample() throws IOException, InterruptedException, ParseException {
        String test = "(!a | b) & a & (a | !(b ^ c))";
        runDrawTest(test, "Sample");
    }

    @Test
    public void testXor() throws ParseException {
        String[] tests = {
                "a ^ b",
                "a ^ a ^ a",
                "a ^ ((b ^ c) ^ (a ^ b)) ^ c",
                "a ^ c ^ d ^ (a ^ (a ^ b) ^ c) ^ (d ^ e)"
        };
        for (String test : tests)
            runTest(test);
    }

    @Test
    public void testOr() throws ParseException {
        String[] tests = {
                "a | b",
                "a | a | a",
                "a | ((b | c) | (a | b)) | c",
                "a | c | d | (a | (a | b) | c) | (d | e)"
        };
        for (String test : tests)
            runTest(test);
    }

    @Test
    public void testAnd() throws ParseException {
        String[] tests = {
                "a & b",
                "a & a & a",
                "a & ((b & c) & (a & b)) & c",
                "a & c & d & (a & (a & b) & c) & (d & e)"
        };
        for (String test : tests)
            runTest(test);
    }

    @Test
    public void testOwn() throws ParseException {
        String[] tests = {
                "a & b | !(!a | !!!(d | !e & l)) ^ !(a & b)",
                "       !!!!x     &   !!y |    !(s   |  a & !   b)",
                "d | (d) | (e & a ^ a | (c) ^ (!a) | c) | (b) | (!e) ^ (!a ^ (c))"
        };
        for (String test : tests)
            runTest(test);
    }

    @Test
    public void testEmpty() throws ParseException {
        String test = "";
        runTest(test);
    }

    @Test
    public void testIllegalInput() throws Exception {
        String[] tests = {
                "a + b - d",
                "!x & d | b * c",
                "!(d & c) | a b =",
                "!!x & a | b)))"
        };
        for (String test : tests)
            runFailTest(test);
    }

    @Test
    public void testIncorrectInput() throws Exception {
        String[] tests = {
                "a || b & c",
                "!!x & a | (b & c",
                "b)))",
                "!!x & a | b)))",
                "!!x & () | b",
                "x !& a",
                "x ! a",
                "x () c",
                "x &",
                "x |",
                "x ^",
                "& x",
                "|a",
                "d | (d) | (e & a ^ a | (c) ^ (!a) | c) | b) | (!e) ^ (!a ^ (c))"
        };
        for (String test : tests)
            runFailTest(test);
    }

    @Test
    public void randomTests() throws ParseException {
        for (int i = 0; i < 1000; i++) {
            RandomTestGenerator generator = new RandomTestGenerator(20 + i * 10);
            String test = generator.generateTest();
            runTest(test);
        }
    }

    private void runFailTest(String testString) throws Exception {
        try {
            parser.parse(testString);
        } catch (AssertionError | ParseException e) {
            return;
        }
        throw new Exception("Expected fail in test: " + testString);
    }

    private void runTest(String testString) throws ParseException {
        parser.parse(testString);
        System.out.println(testString);
    }

    private void runDrawTest(String testString, String name) throws IOException, InterruptedException, ParseException {
        Tree expression = parser.parse(testString);
        painter.draw(expression, "results", name);
        System.out.println(testString);
    }
}