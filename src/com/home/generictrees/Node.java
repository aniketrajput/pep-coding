package com.home.generictrees;

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
