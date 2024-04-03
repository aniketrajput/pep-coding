package com.home.generic_trees_level1;

public class DisplayTree2 {
    public static void displayTree(Node node) {
        String str = node.data + " -> ";

        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            displayTree(child);
        }
    }
}
