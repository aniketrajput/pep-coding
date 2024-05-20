package com.home.generic_trees_level_1;

import java.util.Stack;

/*
Algorithm -
1. Traverse the Euler path array.
2. If element is not -1:
Create a Node
Check if it is the first element in stack, if yes then make it as root
If no, then check the Latest element in stack and add it as its child
Push this node as well in stack
3. If element is -1 then pop it from stack, it means that node is complete and doesn't have any more childrens 4. Return root
*/

public class TreeConstructor1 {
    public static Node buildGenericTree() {
//        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};        //data in Euler's path

//        int arr[] = {10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};     //Data for NodeWithMaxSubtreeSum26

        int arr[] = {10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};       //IterableIterator

        Node root = null;
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = arr[i];
                if (stack.size() > 0) {
                    stack.peek().children.add(node);
                } else {
                    root = node;    //first element in stack will be root
                }
                stack.push(node);
            }
        }
        return root;
    }
}
