package com.home.binary_trees_level_1;

public class DisplayBinaryTree {
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        //faith that left and right children will display their own families
        display(node.left);
        display(node.right);
    }
}
