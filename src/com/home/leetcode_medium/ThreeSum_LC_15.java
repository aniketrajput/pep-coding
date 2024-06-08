package com.home.leetcode_medium;

/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]

        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

Example 2:
        Input: nums = [0,1,1]
        Output: []

        Explanation: The only possible triplet does not sum up to 0.

Example 3:
        Input: nums = [0,0,0]
        Output: [[0,0,0]]

        Explanation: The only possible triplet sums up to 0.

Constraints:
        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105

*/


import java.util.*;

public class ThreeSum_LC_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {             //fix the first element and find other two elements

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}

/*

 Brute Force
    Iterate over each element and in nested loop check for triplet combination

    Time - O(n^3)

Efficient Solution
        - Similar to 2-sum problem, with some additional logic
        - Sort array
        - Fix one element - and consider remaining elements as a set of array where we will apply 2 pointers logic to achive the target as 0 considering 2 pointers values + fix element value
        - In next iteration fix next element, and remaining elements we will apply 2 pointer logic (Here in remaining elements we will not consider element we fixed in previous iteration)
        - Since we need unique triplets, we can add them in HashSet

        Time - O(n^2)
        Space - O(n)
*/
