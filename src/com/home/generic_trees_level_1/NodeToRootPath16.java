package com.home.generic_trees_level_1;

//Faith - if element is found in any child family, it will return us the path from that element node till child node. Root node will have to add itself in this path to make it complete.


import java.util.ArrayList;

public class NodeToRootPath16 {
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList();
            list.add(node.data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);

            if (pathTillChild.size() > 0) {             // As soon as it gets the answer, it will start returning without making any further recursive calls due to this if condition. So while it is returning back we have chance to capture its path.
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }

        return new ArrayList<>();   //return empty arrayList if data not found.
    }

}

//Low level analysis or dry run is important to understand every solution