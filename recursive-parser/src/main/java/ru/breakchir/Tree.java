package ru.breakchir;

import java.util.Arrays;
import java.util.List;

public class Tree {
    String value;
    List<Tree> children;

    public Tree(String node, Tree... children) {
        this.value = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.value = node;
    }

    public boolean isTerminal() {
        return !(value.charAt(0) >= 'A' && value.charAt(0) <= 'Z');
    }
}
