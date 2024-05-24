package com.home.leetcode_easy_collection;
/*

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Implement KthLargest class:
        - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
        - int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:
        Input
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        Output
        [null, 4, 5, 5, 8, 8]

        Explanation
        KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

Constraints:
        1 <= k <= 104
        0 <= nums.length <= 104
        -104 <= nums[i] <= 104
        -104 <= val <= 104
        At most 104 calls will be made to add.
        It is guaranteed that there will be at least k elements in the array when you search for the kth element.

*/


import java.util.PriorityQueue;

public class KthLargestElementInAStream_LC_703 {
    private int k;
    private int[] nums;
    private PriorityQueue<Integer> minHeap;

    public KthLargestElementInAStream_LC_703(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}


/*

Brute Force -
    - Sort array - nlogn time complexity
    - Adding new element - using binary search, and then adding at appropriate position - binary search will take log(n) also shifting will take place, so it will be n time complexity for shifting.

Using Min Heap -
        - Questions like Kth largest or smallest use heap
            If largest - use min heap
            If smallest - use max heap
        - We need to find largest, and remove smallest, in min heap smallest are at top, so can be removed easily, so use min heap.
        - We will pop from heap when heap size is greater than k. Even when inserting initial data [4 5 8 2] maintain heap size 3.
        - At max, heap size will be K, and when we insert a new item in heap, it takes log(K) time to re-adjust or re-heapify itself. We have n elements so worst case O(nlog(k)) will be time complexity which is better than nlog(n)
        - Add function is called m times, and when we add you can notice we also pop, so everytime it will take log(K) when we add-delete, so total O(Mlog(k))

        1. min heap
        2. if > K , pop
        3. add, > K, pop, return top

*/
