package com.home.generictrees;

//Don't check data. Tree should be same in shape or structure. If N1 node of T1 tree has n number of children then in T2 at same place N2 should have same number of children

public class SameTreeByStructure19 {
    public static boolean isSameByStructure(Node node1, Node node2) {
        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        for (int i = 0; i < node1.children.size(); i++) {
            Node childNodeT1 = node1.children.get(i);
            Node childNodeT2 = node2.children.get(i);

            if (isSameByStructure(childNodeT1, childNodeT2) == false) {
                return false;           //return false, don't make any further recursive calls
            }
        }

        return true;
    }
}
