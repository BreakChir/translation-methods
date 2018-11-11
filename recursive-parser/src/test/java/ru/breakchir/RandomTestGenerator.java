package ru.breakchir;

import java.util.Random;

public class RandomTestGenerator {
    private StringBuilder builder;
    private Random random;
    private int letterCount;
    private int balance;
    private int maxLength;
    private int length;

    RandomTestGenerator(int maxLength) {
        builder = new StringBuilder();
        random = new Random(maxLength);
        this.maxLength = maxLength;
        letterCount = 5;
    }

    public String generateTest() {
        buildExpression();
        return builder.toString();
    }

    private void buildExpression() {
        boolean isLetter = true;
        while (length < maxLength) {
            boolean isOpen = isOpen();
            boolean isUnary = isUnary();
            if (isLetter && isOpen) {
                append('(');
                balance++;
            }
            if (isLetter && isUnary)
                append('!');
            if (isLetter && isLetter()) {
                append(getLetter());
                if (isClose()) {
                    append(')');
                    balance--;
                }
                isLetter = false;
                continue;
            }
            if (!isLetter) {
                append(getOperation());
                isLetter = true;
            }
        }
        endExpression(isLetter);
    }

    private int getProbability() {
        return random.nextInt(100);
    }

    private char getOperation() {
        int probability = getProbability();
        if (probability > 70)
            return '^';
        if (probability > 35)
            return '|';
        return '&';
    }

    private char getLetter() {
        return (char) ('a' + random.nextInt(letterCount));
    }

    private boolean isOpen() {
        return getProbability() > 70;
    }

    private boolean isClose() {
        if (balance == 0) return false;
        return getProbability() > 70;
    }

    private boolean isUnary() {
        return getProbability() > 70;
    }

    private boolean isLetter() {
        return getProbability() > 10;
    }

    private void append(char c) {
        builder.append(c);
        length++;
    }

    private void endExpression(boolean isLetter) {
        if (isLetter)
            builder.append(getLetter());
        while (balance > 0) {
            builder.append(')');
            balance--;
        }
    }
}
