package com.home.generic_trees_level_1;

import java.util.ArrayList;

//Check analysis in notebook

public class DistanceBetweenNodes18 {
    public static int distanceBetweenNodes(Node node, int data1, int data2) {
        ArrayList<Integer> pathToData1 = NodeToRootPath16.nodeToRootPath(node, data1);
        ArrayList<Integer> pathToData2 = NodeToRootPath16.nodeToRootPath(node, data2);

        int i = pathToData1.size() - 1;
        int j = pathToData2.size() - 1;

        while (i >= 0 && j >= 0 && pathToData1.get(i) == pathToData2.get(j)) {      //starting from end of both arraylist, check if both element at given index are same, if they are same decrement the indexes and check again until we get unequal elements. When we get unequal elements it means that path till previous element was commmon so increment i and j and return i+j.
            i--;
            j--;
        }

        i++;
        j++;

        return i + j;
    }
}
