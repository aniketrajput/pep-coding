package com.home.leetcode_easy_collection;
/*

Given an integer array nums, find the subarray with the largest sum, and return its sum.

        Example 1:

        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
        Example 2:

        Input: nums = [1]
        Output: 1
        Explanation: The subarray [1] has the largest sum 1.
        Example 3:

        Input: nums = [5,4,-1,7,8]
        Output: 23
        Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


        Constraints:

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104


        Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

public class MaximumSubArray_LC_53 {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int overall_max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > overall_max) {
                overall_max = sum;
            }

            //It doesn't make sense to take -ve sum ahead to calculate sum future with next element. Because it will only reduce the sum. If next element in -ve or +ve it will reduce the sum. So if sum becomes -ve reset to 0.
            // Here when we are doing sum = 0, we are actually starting a new substring.
            if (sum < 0) {
                sum = 0;
            }
        }

        return overall_max;
    }

    public static int printSubArrayWithMaxSum(int[] nums) {
        int sum = 0;
        int overall_max = Integer.MIN_VALUE;
        int startOfNewSubArrayIndex = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {         //when sum is 0, it indicates we are starting a new sub-array
                startOfNewSubArrayIndex = i;
            }

            sum += nums[i];

            if (sum > overall_max) {
                overall_max = sum;
                startIndex = startOfNewSubArrayIndex;
                endIndex = i;
            }

            //It doesn't make sense to take -ve sum ahead to calculate sum future with next element. Because it will only reduce the sum. If next element in -ve or +ve it will reduce the sum. So if sum becomes -ve reset to 0.
            // Here when we are doing sum = 0, we are actually starting a new substring.
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Start index: " + startIndex + ", End index: " + endIndex);

        return overall_max;
    }

}
