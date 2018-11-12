package ru.breakchir;

import java.util.Random;

public class PrefixBoolGenerator {
    private StringBuilder builder;
    private Random random;
    private int balance;
    private int maxLength;

    PrefixBoolGenerator(int maxLength) {
        builder = new StringBuilder();
        random = new Random(maxLength);
        this.maxLength = maxLength;
        balance = 0;
    }

    PrefixBoolGenerator(int maxLength, int rand) {
        builder = new StringBuilder();
        random = new Random(rand);
        this.maxLength = maxLength;
        balance = 0;
    }

    public String generateBool() {
        buildExpression();
        return builder.toString();
    }

    private void buildExpression() {
        for (int i = 0; i < maxLength; i++) {
            if (isOp()) {
                builder.append(getOperation());
                balance = i == 0 ? 2 : balance + 1;
            } else {
                getArg();
                builder.append(' ');
                balance--;
                if (balance <= 0) return;
            }
        }
        endExpression();
    }

    private void endExpression() {
        for (int i = 0; i < balance; i++) {
            builder.append(' ').append(getLetter()).append(' ');
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
        if (probability > 70)
            return "&& ";
        if (probability > 30)
            return "|| ";
        return "^ ";
    }

    private void getArg() {
        int pr = getProbability();
        if (pr > 80) builder.append("true ");
        else if (pr > 60) builder.append("false ");
        else if (pr > 20) {
            getIntCmp();
        } else builder.append(getLetter());
    }

    private void getIntCmp() {
        int pr = getProbability();
        if (pr > 85) {
            builder.append("< ");
        } else if (pr > 60) {
            builder.append("<= ");
        } else if (pr > 50) {
            builder.append(">" );
        } else if (pr > 40) {
            builder.append(">= ");
        } else if (pr > 20) {
            builder.append("== ");
        } else {
            builder.append("!= ");
        }
        builder.append(random.nextInt(100)).append(' ');
        builder.append(random.nextInt(100)).append(' ');
    }

    public char getLetter() {
        return (char) ('a' + random.nextInt(10));
    }
}
