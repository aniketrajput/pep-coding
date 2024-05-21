package com.home.leetcode_easy_collection;

/*

You are given an array of integers stones where stones[i] is the weight of the ith stone.
We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
        - If x == y, both stones are destroyed, and
        - If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.
Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1:
        Input: stones = [2,7,4,1,8,1]
        Output: 1

Explanation:
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
        Input: stones = [1]
        Output: 1

Constraints:

        1 <= stones.length <= 30
        1 <= stones[i] <= 1000

*/

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight_LC_1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }

        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();

            if (x > y) {
                queue.add(x - y);
            }

            //if x == y we don't need to add, x cannot be greater than y as items were fetched from MaxHeap
        }

        if (queue.isEmpty())
            return 0;
        else
            return queue.poll();
    }

}

/*

We can use sorting approach. Sort it in desc order in every iteration. Not optimised as need to sort everytime

Sorting is there, so we can think of Heap, and we need maximum values so we can use maxHeap.

We will use PriorityQueue in Java, which internally implements Heap and default is Min Heap.

A Heap is a complete binary tree data structure that satisfies the heap property: for every node, the value of its children is less than or equal to its own value. Heaps are usually used to implement priority queues, where the smallest (or largest) element is always at the root of the tree.

What is Heap Data Structure?
    A heap is a binary tree-based data structure that satisfies the heap property: the value of each node is greater than or equal to the value of its children. This property makes sure that the root node contains the maximum or minimum value (depending on the type of heap), and the values decrease or increase as you move down the tree.

Types of Heaps
    There are two main types of heaps:

    Max Heap: The root node contains the maximum value, and the values decrease as you move down the tree.
    Min Heap: The root node contains the minimum value, and the values increase as you move down the tree.

Heap Operations
Common heap operations are:

    Insert: Adds a new element to the heap while maintaining the heap property.
    Extract Max/Min: Removes the maximum or minimum element from the heap and returns it.
    Heapify: Converts an arbitrary binary tree into a heap.

Heaps are commonly used to implement priority queues, where elements are retrieved based on their priority (maximum or minimum value).
Heapsort is a sorting algorithm that uses a heap to sort an array in ascending or descending order.
Heaps are used in graph algorithms like Dijkstra’s algorithm and Prim’s algorithm for finding the shortest paths and minimum spanning trees.

Converting default Min Heap to Max Heap -

    Method 1:
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

    Method 2:
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a);

    Method 3:
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b.compareTo(a));

    Method 4:
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> (
            new Comparator<Integer> () {
                public int compare(Integer a, Integer b) {
                        return b - a;
                    }
            }
        );

*/





