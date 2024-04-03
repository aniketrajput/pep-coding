package com.home.generic_trees_level1;

import java.util.ArrayList;

public class LowestCommonAncestor17 {
    public static int lowestCommonAncestor(Node node, int data1, int data2) {
        ArrayList<Integer> pathToData1 = NodeToRootPath16.nodeToRootPath(node, data1);
        ArrayList<Integer> pathToData2 = NodeToRootPath16.nodeToRootPath(node, data2);

        int i = pathToData1.size() - 1;
        int j = pathToData2.size() - 1;

        while (i >= 0 && j >= 0 && pathToData1.get(i) == pathToData2.get(j)) {      //starting from end of both arraylist, check if both element at given index are same, if they are same decrement the indexes and check again until we get unequal elements. When we get unequal elements it means that previous element was commmon ancestor so increment i and return element on that index.
            i--;
            j--;
        }

        i++;

        return pathToData1.get(i);
    }

}
