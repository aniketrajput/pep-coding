package com.home.binary_trees_level_1;

import java.util.Stack;

/*

Check logic and analysis in notebook

*/

public class ConstructBinaryTree {
    public static Node constructBinaryTree() {
        Integer arr[] = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);

        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);               //initially push root in stack

        int index = 0;

        while (!stack.isEmpty()) {
            Pair top = stack.peek();

            if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    Node leftNode = new Node(arr[index], null, null);
                    top.node.left = leftNode;                                       //add left node to left of top node
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                }
                else {                                                               //check if we need this else block, because we are already setting left and right nodes as null when we create there parent
                    top.node.left = null;
                }
                top.state++;
            }
            else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    Node rightNode = new Node(arr[index], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 1);
                    stack.push(rightPair);
                }
                else {
                    top.node.right = null;
                }
                top.state++;
            }
            else {
                stack.pop();
            }
        }

        return root;
    }
}
