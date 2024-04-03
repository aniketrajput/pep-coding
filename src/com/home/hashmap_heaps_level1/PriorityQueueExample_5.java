package com.home.hashmap_heaps_level1;

/*
PriorityQueue -
	add(), remove() and peek()
	By default smaller value is the highest priority
	When we do peek() - it will give the lowest value as it is default priority
	Order is not maintained while inserting
Everything will get printed sorted.
*/

import java.util.PriorityQueue;

public class PriorityQueueExample_5 {
    public static void displayPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();       //inside constructor, we can pass Collections.reverseOrder(), this will change priority to higher value from default lower values
        int[] ranks = {22, 99, 3, 11, 88, 4, 1};

        for (int val : ranks) {
            priorityQueue.add(val);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek());
            priorityQueue.remove();                     //if we don't remove it will run in infinite loop. Current peek item will be removed.
        }
    }
}
