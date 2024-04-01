package com.home.generictrees;

/*

K = 3, find 3rd largest amongst the tree -
If we ask for +infinity floor, we will get 120.
If we ask for 120 floor we will get 110.
If we ask for 110 floor we will get 100.

Check if we can get K lowest using this approach, using ceil

*/

public class KthLargestAndSmallestElement25 {
    static int ceil = Integer.MAX_VALUE;       //Identity of Integer.MAX_VALUE is +infinity. If no ceil is found then default will be +infinity.
    static int floor = Integer.MIN_VALUE;      //Identity of Integer.MIN_VALUE is -infinity. If no floor is found then default will be -infinity.

    public static void findCeilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }

        for (Node child : node.children) {
            findCeilAndFloor(child, data);
        }
    }

    public static int findKthLargest(Node node, int k) {
        int factor = Integer.MAX_VALUE;         //we want to start and find floor of +infinity

        for (int i = 0; i < k; i++) {
            findCeilAndFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;          //we will have to reset floor for next call to find new floor
        }

        return factor;
    }

    public static int findKthSmallest(Node node, int k) {
        int factor = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            findCeilAndFloor(node, factor);
            factor = ceil;
            ceil = Integer.MAX_VALUE;
        }

        return factor;
    }

}
