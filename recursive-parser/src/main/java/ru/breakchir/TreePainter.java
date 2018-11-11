package ru.breakchir;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class TreePainter {
    private StringBuilder builder;

    TreePainter() {
        builder = new StringBuilder();
    }

    private void createIdLine(Tree tree, int id) {
        builder.append(id).
                append(" ").
                append("[label=\"").
                append(tree.value).
                append("\"").
                append(tree.isTerminal() ? ", color=red" : "").
                append("];").
                append(System.lineSeparator());
    }

    private int getId(Tree tree) {
        return System.identityHashCode(tree);
    }

    private void getChildrenLine(Tree tree) {
        if (tree.children == null) return;
        Iterator<Tree> it = tree.children.iterator();
        while (it.hasNext()) {
            builder.append(getId(it.next()));
            if (it.hasNext()) {
                builder.append(" ");
            }
        }
    }

    private void dfs(Tree tree) {
        int id = getId(tree);
        createIdLine(tree, id);
        builder.append(id).
                append(" -> {");
        getChildrenLine(tree);
        builder.append("};").
                append(System.lineSeparator());
        if (tree.children == null) {
            return;
        }
        for (Tree ch : tree.children) {
            dfs(ch);
        }
    }

    private  String print(Tree tree) {
        dfs(tree);
        return builder.toString();
    }

    private void printToFile(Tree tree, String directory, String name) {
        try (PrintWriter writer = new PrintWriter(directory + "/" + name + ".dot")) {
            writer.write("digraph " + name + " {" + System.lineSeparator() +
                    print(tree) + "}"
            );
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void clean(String directory, String name) {
        builder = new StringBuilder();
        File dotFile = new File(directory + "/" + name + ".dot");
        if (!dotFile.delete()) {
            System.err.println("Can't delete " + directory + "/" + name + ".dot");
        }
    }

    private void draw(String directory, String name) throws IOException, InterruptedException {
        new ProcessBuilder("C:/Program Files/graphviz-2.38/release/bin/dot", "-Tpng",
                directory + "/" + name + ".dot")
                .redirectOutput(new File(directory + "/" + name + ".png"))
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start()
                .waitFor();
    }

    void draw(Tree tree, String directory, String name) throws IOException, InterruptedException {
        printToFile(tree, directory, name);
        draw(directory, name);
        clean(directory, name);
    }
}
