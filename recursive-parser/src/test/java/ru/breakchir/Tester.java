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
        String test = " (!a | b) & a & (a | !(b ^ c))";
        runTest(test, "Sample");
    }

    @Test
    public void testXor() throws IOException, InterruptedException, ParseException {
        String[] tests = {
                "a ^ b",
                "a ^ a ^ a",
                "a ^ ((b ^ c) ^ (a ^ b)) ^ c",
        };
        for (int i = 0; i < tests.length; i++)
            runTest(tests[i], "testXor" + i);
    }

    @Test
    public void randomTests() throws IOException, InterruptedException, ParseException {
        for (int i = 0; i < 10; i++) {
            RandomTestGenerator generator = new RandomTestGenerator(20 + i * 10);
            String test = generator.generateTest();
            runTest(test, "random" + i);
        }
    }

    private void runTest(String testString, String name) throws IOException, InterruptedException, ParseException {
        System.out.println(testString);
        parser.parse(testString);
    }

    private void runDrawTest(String testString, String name) throws IOException, InterruptedException, ParseException {
        System.out.println(testString);
        Tree expression = parser.parse(testString);
        painter.draw(expression, "results", name);
    }
}