package com.home.generic_trees_level1;

//Predecessor and Successor of a node means, immediate node before and after from eulers path preorder

public class PredecessorSuccessor23 {
    static Node predecessor = null;
    static Node successor = null;
    static int state = 0;

    public static void findPredecessorAndSuccessor(Node node, int data) {
        if(state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;            //keep changing predecessor. When data matches we will have previous data here.
            }
        } else if(state == 1) {
            state = 2;                              //once state changed to 1 in previous iteration, the immediate current node will be successor.
            successor = node;
        }

        for (Node child : node.children) {              //iterate over each child nodes
            findPredecessorAndSuccessor(child, data);
        }
    }

    public static void displayPredecessorAndSuccessor() {
        if (predecessor != null)
            System.out.println("Predecessor: " + predecessor.data);

        if (successor != null)
            System.out.println("Successor: " + successor.data);
    }
}
