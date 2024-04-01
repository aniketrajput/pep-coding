package com.home.generictrees.iterableiterator;

import com.home.generictrees.Node;

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
