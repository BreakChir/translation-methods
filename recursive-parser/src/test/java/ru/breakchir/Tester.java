package ru.breakchir;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

public class Tester {
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

    @Test(expected = Exception.class)
    public void testIllegal1() throws Exception {
        runFailTest("a + b - d");
    }

    @Test(expected = Exception.class)
    public void testIllegal2() throws Exception {
        runFailTest("!x & d | b * c");
    }

    @Test(expected = Exception.class)
    public void testIllegal3() throws Exception {
        runFailTest("!(d & c) | a b =");
    }

    @Test(expected = Exception.class)
    public void testIncorrect1() throws Exception {
        runFailTest("a || b & c");
    }

    @Test(expected = Exception.class)
    public void testIncorrect2() throws Exception {
        runFailTest("!!x & a | (b & c");
    }

    @Test(expected = Exception.class)
    public void testIncorrect3() throws Exception {
        runFailTest("b)");
    }

    @Test(expected = Exception.class)
    public void testIncorrect4() throws Exception {
        runFailTest("!!x & a | b)))");
    }

    @Test(expected = Exception.class)
    public void testIncorrect5() throws Exception {
        runFailTest("!!x & () | b");
    }

    @Test(expected = Exception.class)
    public void testIncorrect6() throws Exception {
        runFailTest("x ! a");
    }

    @Test(expected = Exception.class)
    public void testIncorrect7() throws Exception {
        runFailTest( "x !& a");
    }

    @Test(expected = Exception.class)
    public void testIncorrect8() throws Exception {
        runFailTest("x () c");
    }

    @Test(expected = Exception.class)
    public void testIncorrect9() throws Exception {
        runFailTest("x &");
    }

    @Test(expected = Exception.class)
    public void testIncorrect10() throws Exception {
        runFailTest("x |");
    }

    @Test(expected = Exception.class)
    public void testIncorrect11() throws Exception {
        runFailTest("x ^");
    }

    @Test(expected = Exception.class)
    public void testIncorrect12() throws Exception {
        runFailTest("& x");
    }

    @Test(expected = Exception.class)
    public void testIncorrect13() throws Exception {
        runFailTest("d | (d) | (e & a ^ a | (c) ^ (!a) | c) | b) | (!e) ^ (!a ^ (c))");
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
            throw new Exception("Exception in test: " + testString);
        }
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