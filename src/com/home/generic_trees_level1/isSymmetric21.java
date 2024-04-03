package com.home.generic_trees_level1;

/*
Symmetric trees are mirror of itself.
A binary tree is symmetric if the root node's left subtree is a mirror reflection of the right subtree.
Imagine a line from between a tree and if we fold on that line then will all nodes match..
*/

public class isSymmetric21 {
    public static boolean isSymmetric(Node node) {
        return AreMirrorsByStructure20.areMirrorsByStructure(node, node);
    }
}
