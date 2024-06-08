package com.home.leetcode_easy;
/*

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
        Input: nums = [3,2,3]
        Output: 3

Example 2:
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2

Constraints:
        n == nums.length
        1 <= n <= 5 * 104
        -109 <= nums[i] <= 109

*/

public class MajorityElement_LC_169 {

    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int voting = 1;

        for (int i = 1; i < nums.length; i++) {
            if (majority == nums[i]) {
                voting++;
            } else {
                voting--;
            }

            if (voting == 0) {
                majority = nums[i];
                voting = 1;
            }
        }

        return majority;
    }
}

/*

Brute Force -
        - We will find occurrence count of each unique element
        - n is given, find n/2
        - check which element frequency count is greater than n/2

        Time - TO find out frequency of an array we are iterating this array again and again.

Optimizing for time (using sorting) -
        - Sort the array first
        - Once the array is sorted the majority element group will lie somewhere in array - in beginning, middle or end
        - One think to note is that some part of the majority element will always lie in the middle of the array as it should be > n/2
        - So we can simply look at the middle element of the array and that will be answer

        Time - we just sorted once and returned the middle element. Best Sorting time complexity can be O(n log n)

Solving in O(N) using HashTable -
        - Maintain a Frequency map - can be done only in one iteration - O(N)
        - Scan HashTable once and check which key has value > than n/2

        Here we took some extra space for HashTable


Time and Space efficient solution (Moore's Voting Algorithm) -
        - This is general algorithm used for voting

        Example - [2, 2, 1, 3, 1, 2, 2]

        majority = 2 -> 3 -> 1 -> 2
        votes = 1 -> 2 -> 1 -> 0 -> 1 -> 0 -> 1 -> 0 -> 1 -> 2

        - To start, let the first element be majority with votes = 1
        - If element == majority, increment the vote count
        - If element != majority, decrement the vote count
        -- if votes becomes zero, update the majority element
        -- set votes = 1 for the newer element

        We solved this in just one iteration and didn't take any extra space
        Time - O(N)
        Space - O(1)

*/


