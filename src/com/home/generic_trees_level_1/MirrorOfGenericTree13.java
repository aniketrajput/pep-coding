package com.home.generic_trees_level_1;

import java.util.Collections;

public class MirrorOfGenericTree13 {
    public static Node mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);                          //faith that all children can mirror its whole family
        }
        Collections.reverse(node.children);         //reverse the whole children node family (not data node). Check Euler path diagram. For node with children we need to reverse its children nodes in Post call area.

        return node;
    }
}
