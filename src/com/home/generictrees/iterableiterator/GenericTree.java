package com.home.generictrees.iterableiterator;

import com.home.generictrees.Node;

import java.util.Iterator;

public class GenericTree implements Iterable<Integer>{
    Node root;

    public GenericTree(Node root) {
        this.root = root;
    }

    @Override
    public Iterator<Integer> iterator() {
//        return new GenericTreePreorderIterator(root);         //will print preorder
        return new GenericTreePostorderIterator(root);          //will print postorder
    }

}
