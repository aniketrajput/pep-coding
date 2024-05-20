package com.home.hashmap_heaps_level_1;

/*

K sorted array - Array was sorted but elements in array have moved up to k elements either to left or right.
We need to sort it properly in Time complexity - nlogk and space complexity O(k)
If K is 2, then an element must have moved upto 2 elements i.e. either 1 or 2 elements

	eg - 			2, 3, 1, 4, 6, 7, 5, 8, 9
	compare with -  1, 2, 3, 4, 5, 6, 7, 8, 9

*/

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortKSortedArray_7 {
    public static void sort() {
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

        for (int i = 0; i <= k; i++) {          //add first k elements in queue
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {       //after kth element, first print lowest number from queue and remove it, then add current array element in queue
            System.out.print(pq.remove() + " ");
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {                 //print remaining items in queue
            System.out.print(pq.remove() + " ");
        }

    }
}
