package com.home.generictrees;

import java.util.Stack;

//traversal from level 1 will start from left -> right. Then on level 2 it will be right -> left and on level 3 again left -> right so on..

public class LevelOrderLinewiseZigZag9 {
    public static void levelOrderLinewiseZigZag(Node node) {
        Stack<Node> parentStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();
        int level = 1;

        parentStack.add(node);

        while (!parentStack.isEmpty()) {
            node = parentStack.pop();

            System.out.print(node.data + " ");

            if (level % 2 == 1) {       //odd level. We go left -> right. Children should also get added in childQueue left -> right, then only we can pop them and print in right -> left (reverse from current order) in next level
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    childStack.push(child);
                }
            }
            else {                    //even level. We go right -> left. Children should also get added in childQueue right -> left, then only we can pop them and pringt in left -> right (reverse from current order) in next level
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    childStack.push(child);
                }
            }

            if (parentStack.size() == 0) {
                parentStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }

        }

    }
}
