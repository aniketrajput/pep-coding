package com.home.generic_trees_level_1;

/*

Ceil means smallest amongst larger or just larger - bado me sabse chota
Floor means largest amongst smaller or just smaller - choto me sabse bada

If you want ceil and floor of 5, and 10 is root node or there is no node smaller than 5, then it ceil will be 10 and floor will be -infinity
If we want to know ceil and floor of 125 and there is no node bigger than 125 then its ceil will be +infinity

*/

public class CeilAndFloor24 {
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

    public static void displayCeilAndFloor() {
        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}
