package com.home.generic_trees_level1;

//Faith - child node knows how to find given element in its family and will return true or false.

public class FindElementInTree15 {
    public static boolean findElement(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        for (Node child : node.children) {
            boolean isPresentInChild = findElement(child, data);
            if (isPresentInChild) {                                 //As soon as it gets the answer,  it will start returning without making any further recursive calls due to this if condition. So complete Eulers path is not executed.
                return true;
            }
        }

        return false;
    }
}
