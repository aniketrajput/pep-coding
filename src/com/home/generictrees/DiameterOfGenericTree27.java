package com.home.generictrees;

/*
Diameter of generic tree - diameter of generic tree means, largest distance between two nodes (in term of edges)
If a is a root node, find depth of each of its child, take the largest depth + second largest depth + 2(edges of each child) = diameter
Above solution will node work always, suppose only one child's subtree of root had a diameter within itself.
Solution to above issue is, calculate deepest child + second depest child + 2, on each node. Which every node will have max diameter will be answer.

*/

public class DiameterOfGenericTree27 {
    static int diameter = 0;

    public static int findDiameterOfGenericTree(Node node) {
        int deepestHeight = -1;             //deepest height of current iteration node
        int secondDeepestHeight = -1;       //second deepest height of current iteration node

        for (Node child : node.children) {
            int childHeight = findDiameterOfGenericTree(child);         //faith that child can return its own height

            if (childHeight > deepestHeight) {              //for each node check for deepest and second-deepest height
                secondDeepestHeight = deepestHeight;
                deepestHeight = childHeight;
            }
            else if (childHeight > secondDeepestHeight) {
                secondDeepestHeight = childHeight;
            }
        }

        //in post order check and calculate diameter
        int candidate = deepestHeight + secondDeepestHeight + 2;
        if (candidate > diameter) {                                 //if current node's candidate is greater than existing diameter then it is new diameter
            diameter = candidate;
        }

        deepestHeight += 1;         //add height of current node; Before adding its own height calculate diameter, because we are considering this edge or height when we add 2 while calculating diameter

        return deepestHeight;
    }

    public static void displayDiameter() {
        System.out.println("Diameter: " + diameter);
    }

}
