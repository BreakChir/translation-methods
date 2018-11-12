package ru.breakchir;

import java.util.Random;

public class PrefixNumGenerator {
    private StringBuilder builder;
    private Random random;
    private int balance;
    private int maxLength;

    PrefixNumGenerator(int maxLength) {
        builder = new StringBuilder();
        random = new Random(maxLength);
        this.maxLength = maxLength;
        balance = 0;
    }

    PrefixNumGenerator(int maxLength, int rand) {
        builder = new StringBuilder();
        random = new Random(rand);
        this.maxLength = maxLength;
        balance = 0;
    }

    public String generateNum() {
        balance = 0;
        buildExpression();
        return builder.toString();
    }

    private void buildExpression() {
        for (int i = 0; i < maxLength; i++) {
            if (isOp()) {
                builder.append(getOperation());
                balance = balance == 0 ? 2 : balance + 1;
            } else {
                builder.append(getNum()).append(' ');
                balance--;
                if (balance <= 0) return;
            }
        }
        endExpression();
    }

    private void endExpression() {
        for (int i = 0; i < balance; i++) {
            builder.append(' ').append(getNum()).append(' ');
        }
    }

    private boolean isOp() {
        return random.nextInt(100) > 30;
    }

    private int getProbability() {
        return random.nextInt(100);
    }

    private String getOperation() {
        int probability = getProbability();
        if (probability > 80)
            return "+ ";
        if (probability > 60)
            return "- ";
        if (probability > 40)
            return "+ ";
        if (probability > 20)
            return "/ ";
        return "% ";
    }

    public String getNum() {
        return Integer.toString(random.nextInt(100));
    }
}
