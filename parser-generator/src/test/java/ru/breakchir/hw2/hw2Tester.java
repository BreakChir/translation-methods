package ru.breakchir.hw2;

import java.text.ParseException;

import org.junit.Test;

public class hw2Tester {
    private hw2Parser parser = new hw2Parser();

    @Test
    public void testSample() throws ParseException {
        String test = "a ^ b";
        runTest(test);
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
    public void testIllegalCharacter() {
        String[] tests = {
                "a + b - d",
                "!x & d | b * c",
                "!(d & c) | a b ="
        };
        for (String test : tests)
            runFailTest(test);
    }

    @Test
    public void testIncorrectInput() {
        String[] tests = {
                "a || b & c",
                "!!x & a | (b & c",
                "b)",
                "!!x & a | b)))",
                "!!x & () | b",
                "x !& a",
                "x ! a",
                "x () c",
                "x &",
                "x |",
                "x ^",
                "& x",
                "d | (d) | (e & a ^ a | (c) ^ (!a) | c) | b) | (!e) ^ (!a ^ (c))"
        };
        for (String test : tests)
            runFailTest(test);
    }

    @Test
    public void randomTests() throws ParseException {
        for (int i = 0; i < 500; i++) {
            RandomTestGenerator generator = new RandomTestGenerator(20 + i * 10);
            String test = generator.generateTest();
            runTest(test);
        }
    }

    private void runFailTest(String testString) {
        try {
            parser.parse(testString);
        } catch (AssertionError e) {
            System.out.println("Assertion Error in test: " + testString);
        } catch (ParseException e) {
            System.out.println("Parse Exception in test: " + testString);
            System.out.println("Incorrect token at position: " + e.getErrorOffset());
        }
    }

    private void runTest(String testString) throws ParseException {
        System.out.println(parser.parse(testString).v);
    }

}