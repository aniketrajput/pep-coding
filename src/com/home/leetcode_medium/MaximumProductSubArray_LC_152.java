package com.home.leetcode_medium;

/*

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
        Input: nums = [2,3,-2,4]
        Output: 6

        Explanation: [2,3] has the largest product 6.

Example 2:
        Input: nums = [-2,0,-1]
        Output: 0

        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
        1 <= nums.length <= 2 * 104
        -10 <= nums[i] <= 10
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

*/

public class MaximumProductSubArray_LC_152 {

    public static int maxProduct(int[] nums) {
        long leftProduct = 1;
        long rightProduct = 1;
        int answer = nums[0];       //maximum so far
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            //If any leftProduct or rightProduct becomes 0 then update it to 1
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            //Prefix product or product from left side
            leftProduct *= nums[i];

            //Suffix product or product from right side
            rightProduct *= nums[n - 1 - i];

            answer = (int) Math.max(answer, Math.max(leftProduct, rightProduct));
        }

        System.out.println(answer);

        return answer;
    }

}


/*

https://www.youtube.com/watch?v=Y6B-7ZctiW8

Sub-Array - A subarray is a contiguous non-empty sequence of elements within an array.

Brute Force -
        Select each element one by one and try to find sub-arrays

Efficient Solution -

        Case 1: All numbers are positive

        Case 2: Both positive and negative number
            - Even count of negative numbers = the end result of products of all will be positive
            - Odd count of negative numbers = the end result of products of all will be negative

        Case 3: Positive, negative and 0
            This will break into two problems. One to the left of 0 and other to the right of 0 => 2 3 0 -5 6 -1 4

        So Case 2 - Odd count, is the only scenario where we need to solve the problem.

        Example 1 -
           2  3  -2  -5  6  -1  4

            start from left 			start from right		max so far

            2							4						4
            2 * 3 = 6					4 * -1 = -4				6
            6 * -2 = -12				-4 * 6 = -24			6
            -12 * -5 = 60				-24 * -5 = 120			120
            60 * 6 = 360				120 * -2 = -240			360
            360 * -1 = -360				-240 * 3 = -720			360
            -360 * 4 = -1440			-720 * 2 = -1440		360

            Answer = 360

        Example 2 - if it contains 0
            2  3  0  -5  6  -1  4

            start from left 			start from right		max so far

            2							4						4
            2 * 3 = 6					4 * -1 = -4				6
            6 * 0 = 0 => 1				-4 * 6 = -24			6				//if we get product as 0, then we change it to 1
            1 * -5 = -5					-24 * -5 =

            ...

            If we get product as 0, then we know that after these all the subsequent products will be 0, so we will take 1 as product for next multiplication, so technically we splitted our problem into two parts, one is part left to 0 which is already done and other part is right to 0 which we will start.
            Same we have to do one right direction products.

        Time - O(n), as we only do one iteration of all elements
        Space - O(1), because we don't take any extra space

*/
