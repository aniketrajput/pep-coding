package com.home.generictrees;

/*

Print pre-order and post-order don't use recursion, use iterative approach
Pre-order will be on the left of the eulers path
Post-order will be on the right of the eulers path

-1 =>                       Print pre-order and increment state
children.size() =>          Print post-order and pop from stack
0 to children.size() =>     Push child and increment state

*/

import java.util.Stack;

public class IterativePreorderPostorder28 {
    public static void printPreorderPostorder(Node node) {
        String preOrder = "";
        String postOrder = "";
        Stack<PairTraversal> stack = new Stack<>();
        stack.push(new PairTraversal(node, -1));

        while (!stack.isEmpty()) {
            PairTraversal top = stack.peek();

            if (top.state == -1) {
                preOrder += top.node.data + " ";
                top.state++;
            }
            else if(top.state == top.node.children.size()) {
                postOrder += top.node.data + " ";
                stack.pop();
            }
            else {  //0 to children.size()      following condition can be written in if-condition (top.state >= 0 && top.state < top.node.children.size())
                stack.push(new PairTraversal(top.node.children.get(top.state), -1));
                top.state++;
            }
        }

        System.out.println(preOrder);
        System.out.println(postOrder);
    }
}
