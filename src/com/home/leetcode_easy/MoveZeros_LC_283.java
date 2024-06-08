package com.home.leetcode_easy;

/*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

Example 2:
        Input: nums = [0]
        Output: [0]

Constraints:
        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?

*/

public class MoveZeros_LC_283 {

    public void moveZeroes(int[] nums) {
        int insertPosition = 0 ;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        while (insertPosition < nums.length) {
            nums[insertPosition] = 0;
            insertPosition++;
        }
    }
}


/*
Brute Force -
Straight Forward approach (Time efficient) -
        Separate out all 0s in one array and other numbers in other array and then combine both arrays
        Time - O(N)
        Not space efficient as we need to take extra space.

Time and Space Efficient Solution -
        You are only concerned about the non-zero elements, so start from beginning, if we see zero ignore it and if it is non-zero then put it in array.
        At the end fill the array with remaining zeros.

        Time - O(n)
        Space - O(1)
*/
