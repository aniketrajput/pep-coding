package com.home.generic_trees_level1;

// Find and print the node which has the subtree with largest sum. Als print the sum of the concerned subtree separated by node's value by an @

public class NodeWithMaxSubtreeSum26 {
    static int maximumSubtreeNode = 0;
    static int maximumSubtreeSum = Integer.MIN_VALUE;

    public static int findMaximumSubtreeSum(Node node) {
        int sum = 0;       //here we will have sum for current iteration node's subtree. In above static variables we will have, global max sum and node for entire tree.

        for (Node child : node.children) {
            int childNodeSum = findMaximumSubtreeSum(child);    //faith that child will return its own sum
            sum += childNodeSum;                                //add childNodeSum of all children to sum
        }

        sum += node.data;   //add current node's data to sum which already has its children sum

        if (sum > maximumSubtreeSum) {      //in post order check if sum of current node is maximum in tree or current value of global max variable.
            maximumSubtreeNode = node.data;
            maximumSubtreeSum = sum;
        }

        return sum;
    }

    public static void displayNodeWithMaxSubtree() {
        System.out.println(maximumSubtreeNode + " @ " + maximumSubtreeSum);
    }

}
