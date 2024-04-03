package com.home.generic_trees_level1;

import java.util.ArrayDeque;
import java.util.Queue;

//For linewise level order traversal we will use two queues.
//Main queue will store parent and child queue will store next level children of each parent in current node
//When Main queue is emapty, it means one level is over, so we have next level nodes in child queue, copy that to main queue, reset child queue
//Basically remove each node from parent queue, print, add its children in child queue, until parent queue becomes empty, once it becomes empty copy child queue data to parent queue, reset child queue
/*

Approach 1 - using two queues - mainQueue and childQueue
Approach 2 - using delimiter
Approach 3 - count
Approach 4 - use Pair class. We will have Queue<Pair>. Pair will be Node-Level
*/

public class LevelOrderTraversalLinewise8 {
    public static void levelOrderTraversalLinewise(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();
        mainQueue.add(node);

        while (!mainQueue.isEmpty()) {
            node = mainQueue.remove();

            System.out.print(node.data + " ");

            for (Node child : node.children) {      //add children of current node in childQueue to maintain next level nodes
                childQueue.add(child);
            }

            if (mainQueue.size() == 0) {        //if mainQueue has become empty, then current level childs are no more, add next level childs from childQueue to mainQueue, re-initialize childQueue
                mainQueue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

}
