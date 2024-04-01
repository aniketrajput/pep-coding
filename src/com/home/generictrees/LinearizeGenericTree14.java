package com.home.generictrees;

/*
From a given generic tree, we need to create a linear tree (with only one child), starting from pre order of that tree. 

*/


public class LinearizeGenericTree14 {
    public static Node linearizeGenericTree(Node node) {
        for (Node child : node.children) {      //faith that each child will linearize its family
            linearizeGenericTree(child);
        }

        while (node.children.size() > 1) {  //at last only one node should have linear child family
            Node lastChildFamily = node.children.remove(node.children.size() - 1);      //remove the last linearized child family, as we need to link it to second last linearized child family
            Node secondLastChildFamily = node.children.get(node.children.size() - 1);    //we removed last, so this is second last

            Node secondLastLeaf = getTail(secondLastChildFamily);   //get the last node in secondLastChildFamily to link to lastChildFamily
            secondLastLeaf.children.add(lastChildFamily);
        }
        
        return node;
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);        //move to next node
        }
        return node;
    }

//    Above approach had N^2 complexity as in post order as well we were iteraing over nodes to find tail.
//    Changing faith to - each child knows how to linearize its family and it will also return its tail.
//    Efficient approach -

    public static Node linearize2(Node node) {
        if(node.children.size() == 0) {
            return node;
        }

        Node lastKiTail = linearize2(node.children.get(node.children.size() - 1));

        while (node.children.size() > 1) {
            Node lastChildFamily = node.children.remove(node.children.size() - 1);
            Node secondLastChildFamily = node.children.get(node.children.size() - 1);

            Node secondlastKiTail = linearize2(secondLastChildFamily);
            secondlastKiTail.children.add(lastChildFamily);
        }

        return lastKiTail;
    }

}
