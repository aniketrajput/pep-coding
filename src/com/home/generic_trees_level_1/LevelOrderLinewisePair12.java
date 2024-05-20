package com.home.generic_trees_level_1;

import java.util.ArrayDeque;
import java.util.Queue;
/*

Approach 1 - using two queues - mainQueue and childQueue
Approach 2 - using delimiter
Approach 3 - count
Approach 4 - use Pair class. We will have Queue<Pair>. Pair will be Node-Level
*/

public class LevelOrderLinewisePair12 {
    public static void levelOrderLinewisePair(Node node) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node, 1));
        int level = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            if (level < pair.level) {
                level = pair.level;
                System.out.println();
            }

            System.out.print(pair.node.data + " ");

            for (Node child : pair.node.children) {
                queue.add(new Pair(child, pair.level + 1));
            }

        }
    }
}
