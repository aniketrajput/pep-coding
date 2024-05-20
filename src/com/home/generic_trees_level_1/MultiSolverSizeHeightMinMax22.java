package com.home.generic_trees_level_1;

/*
Height is depth of the deepest node.
Re-think on static and local stack variables.
*/

public class MultiSolverSizeHeightMinMax22 {
    static int size = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = 0;

    public static void multiSolver(Node node, int depth) {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);

        for (Node child : node.children) {
            multiSolver(child, depth + 1);
        }
    }

    public static void displayMultiSolver() {
        System.out.println("Size: " + size);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Height: " + height);
    }
}
