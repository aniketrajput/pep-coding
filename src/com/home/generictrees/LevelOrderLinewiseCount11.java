package com.home.generictrees;

/*

In this approach we will first count how many elements present in queue, that count will represent the number od node in that current level
Iterate in a loop for those many counts and - remove from queue, print and add its children
Once number of count iterations are over, it means that level is ended, print enter. Again if queue is not empty new count will be checked and same will repeat.

Approach 1 - using two queues - mainQueue and childQueue
Approach 2 - using delimiter
Approach 3 - count
Approach 4 - use Pair class. We will have Queue<Pair>. Pair will be Node-Level

*/

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderLinewiseCount11 {
    public static void levelOrderLinewiseCount(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int childrenInCurrentLevel = queue.size();

            for (int i = 0; i < childrenInCurrentLevel; i++) {
                node = queue.remove();

                System.out.print(node.data + " ");

                queue.addAll(node.children);

                //above line can be used instead of -
                /*
                for (Node child : node.children) {
                    queue.add(child);
                }
                */
            }

            System.out.println();
        }
    }

}
