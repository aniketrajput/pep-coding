package com.home.hashmap_heaps_level1;

/*

Space complexity is O(k) - because priority queue size will not be bigger than key
Time complexity - nlogk


In priority queue we will keep only k elements.
Iterate the array and add first k elements in queue.
peek() will always have the smallest element, so check if next element after k is greater than peek(), if it is greater than remove smaller element from peek() and add current array element in queue.
Keep doing this until end of array, and finally we will have K largest elements in queue.

*/

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestInArray_6 {
    public static void findKthLargest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter n elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.println("Enter K: ");
        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            if (i < k) {
                pq.add(arr[i]);
            }
            else {
                if (pq.peek() < arr[i]) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
