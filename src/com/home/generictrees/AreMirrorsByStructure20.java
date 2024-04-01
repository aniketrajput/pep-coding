package com.home.generictrees;


public class AreMirrorsByStructure20 {
    public static boolean areMirrorsByStructure(Node node1, Node node2) {
        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        for (int i = 0; i < node1.children.size(); i++) {
            int j = node1.children.size() - 1 - i;          //If there are 3 children and i is on 0th index, then j should be on 2nd index
            Node childNodeT1 = node1.children.get(i);
            Node childNodeT2 = node2.children.get(j);

            if (areMirrorsByStructure(childNodeT1, childNodeT2) == false) {
                return false;
            }
        }

        return true;
    }
}
