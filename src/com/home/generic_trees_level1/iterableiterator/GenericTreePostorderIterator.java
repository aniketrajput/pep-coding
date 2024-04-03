package com.home.generic_trees_level1.iterableiterator;

import com.home.generic_trees_level1.Node;
import com.home.generic_trees_level1.PairTraversal;

import java.util.Iterator;
import java.util.Stack;

public class GenericTreePostorderIterator implements Iterator<Integer> {
    Integer nextVal;
    Stack<PairTraversal> stack;

    public GenericTreePostorderIterator(Node root) {
        stack = new Stack<>();
        stack.push(new PairTraversal(root, -1));
        next();
    }

    @Override
    public boolean hasNext() {
        if (nextVal == null)
            return false;
        else
            return true;
    }

    @Override
    public Integer next() {
        Integer currentVal = nextVal;

        nextVal = null;             //reset nextVal to null, because if there is no more preorder then nextVal should contain null

        while (!stack.isEmpty()) {
            PairTraversal top = stack.peek();

            if (top.state == -1) {
                top.state++;
            }
            else if (top.state >= 0 && top.state < top.node.children.size()) {
                stack.push(new PairTraversal(top.node.children.get(top.state), -1));
                top.state++;
            }
            else  {
                nextVal = top.node.data;
                stack.pop();
                break;
            }
        }

        return currentVal;
    }
}
