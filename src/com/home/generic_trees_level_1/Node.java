package com.home.generic_trees_level_1;

import java.util.ArrayList;

public class Node {
    public int data;
    public ArrayList<Node> children = new ArrayList<>();

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}
