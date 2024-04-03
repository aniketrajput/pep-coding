package com.home.generic_trees_level1.iterableiterator;

import com.home.generic_trees_level1.Node;

public class PrintPreorderPostorder {
    public static void print(Node root) {
        GenericTree tree = new GenericTree(root);

        for (int val : tree) {
            System.out.println(val);
        }

        /*

        Above for loop gets converted into below while loop in background -

        Iterator<Integer> itr = tree.iterator();
        while(itr.hasNext()) {
            return next();
        }

        */
    }
}
