package com.home.generic_trees_level_1;

public class RemoveLeafs14 {
    public static Node removeLeaf(Node node) {
        
        //This loop should be in pre area of euler's path or before recursive call. If we add after recursive call then all nodes will be removed. This happens because some nodes itself becomes leaf after removing there leafs and when post area of this node is called it itself will be removed, which should not happen.
        for (int i = node.children.size() - 1; i >= 0; i--) {   //Here we remove leaf nodes
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        //recursive call to remove leafs of leftover nodes
        for (Node child : node.children) {
            removeLeaf(child);
        }

        return node;
    }
}
