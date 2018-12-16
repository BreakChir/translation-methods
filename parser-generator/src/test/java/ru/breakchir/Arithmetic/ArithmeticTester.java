package ru.breakchir.Arithmetic;

import java.text.ParseException;

import org.junit.Test;

public class ArithmeticTester {
    private ArithmeticParser parser = new ArithmeticParser();

    @Test
    public void testSimple() throws ParseException {
        String test = "1 + 6 * 0 - (8 / 4) ^ 5";
        runTest(test, -31);
    }

    @Test
    public void testOwn() throws ParseException {
        String[] tests = {
                "5",
                "2 -    8   + 3  ^5/        20 * 8    -4                   ",
                "1 + 6 * 0 - (8 / 4) ^ 5",
                "((20 + 4) / 2) ^ 3 / 12"
        };

        int[] answers = {
                5,
                86,
                -31,
                144
        };
        for (int i = 0; i < tests.length; i++)
            runTest(tests[i], answers[i]);
    }

    @Test
    public void testIncorrect() {
        String[] tests = {
                "08+2",
                "245 & 23",
                "5 +",
                "5 *",
                "5 ^",
                "5 () 6",
                "5 -()",
                "() ^ 5",
                "()",
                "   5 + 4 +(3 -2",
                "8 + 3))))",
                "8 + 3)",
                "(8 + 3))"
        };
        for (String test : tests)
            runFailTest(test);
    }

    private void runFailTest(String testString) {
        try {
            parser.parse(testString);
        } catch (AssertionError e) {
            System.out.println("Assertion Error in test: " + testString);
        } catch (ParseException e) {
            System.out.println("Parse Exception in test: " + testString);
            System.out.println("    Incorrect token at position: " + e.getErrorOffset());
        }
    }

    private void runTest(String testString, int answer) throws ParseException {
        System.out.println(parser.parse(testString).v == answer);
    }
}
