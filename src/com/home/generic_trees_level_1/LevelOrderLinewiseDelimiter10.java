package com.home.generic_trees_level_1;

/*

This approach is using only one queue.
Use marker/ delimiter, like -1 after each level end.
When you pop and if you get -1, print enter, and add -1 in queue -> when we get -1 it indicates current level is over and all children of current level node are added, again add -1 to mark end of next level.
Add -1 only when there are some elements in queue.

*/

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderLinewiseDelimiter10 {
    public static void levelOrderLinewiseDelimiter(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));

        while (!queue.isEmpty()) {
            node = queue.remove();

            if (node.data != -1) {
                System.out.print(node.data + " ");

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            else {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.add(new Node(-1));
                }
            }
        }

    }
}
