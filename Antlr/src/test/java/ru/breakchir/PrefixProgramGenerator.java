package ru.breakchir;

import java.util.Random;

public class PrefixProgramGenerator {
    private StringBuilder builder;
    private Random random;
    PrefixNumGenerator numGenerator;
    PrefixBoolGenerator boolGenerator;
    private int balance;
    private int maxLength;

    PrefixProgramGenerator(int maxLength) {
        builder = new StringBuilder();
        random = new Random(maxLength);
        numGenerator = new PrefixNumGenerator(4);
        boolGenerator = new PrefixBoolGenerator(4);
        balance = 0;
        this.maxLength = maxLength;
    }

    public String generateProgram() {
        buildExpression();
        return builder.toString();
    }

    private void buildExpression() {
        for (int i = 0; i < maxLength; i++) {
            balance += getArgSz(0);
            if (balance < 0) balance = 0;
        }
        endExpression();
    }

    private void endExpression() {
        for (int i = 0; i < balance; i++) {
            getArgSz(100);
        }
    }

    private int getArgSz(int end) {
        numGenerator = new PrefixNumGenerator(4, random.nextInt(100000));
        boolGenerator = new PrefixBoolGenerator(4, random.nextInt(100000));
        int op = getProbability() + end;
        int arg = getProbability();
        if (op > 70) {
            if (op > 85)
                builder.append("print ");
            else {
                builder.append("= ");
                builder.append(boolGenerator.getLetter()).append(' ');
            }
            if (arg > 70) {
                builder.append(numGenerator.generateNum());
            } else if (arg > 35) {
                builder.append(boolGenerator.generateBool());
            } else {
                builder.append(boolGenerator.getLetter());
            }
            builder.append(' ');
            return -1;
        } else if (op > 20) {
            builder.append("if ");
            builder.append(boolGenerator.generateBool());
            int argsSz = getProbability();
            if (argsSz > 50) {
                return 2;
            } else {
                return 1;
            }
        } else {
            builder.append("begin ");
            return 0;
        }
    }

    private int getProbability() {
        return random.nextInt(100);
    }
}
