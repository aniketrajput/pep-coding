package com.home.leetcode_easy;
/*

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
        Input: nums = [4,3,2,7,8,2,3,1]
        Output: [5,6]

Example 2:
        Input: nums = [1,1]
        Output: [2]

Constraints:
        n == nums.length
        1 <= n <= 105
        1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

*/

import java.util.ArrayList;
import java.util.List;

public class FindNumbersDisappearedInArray_LC_448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;              //[4,3,2,7,8,2,3,1] => 4 - 1 = 3; 3th index will change to -7 = [4,3,2,-7,8,2,3,1]; When we are reading 3rd element i.e. -7 we need to use Math.abs(), as we cannot take -ve index.

            if (nums[index] < 0)
                continue;
            else
                nums[index] = nums[index] * -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

}


/*

Brute Force -
        - Find size of array, means it will have elements from 1 - n
        - Iterate 1 to n and find missing numbers.

        If array is huge, it won't be time efficient solution.

Time and space efficient solution -
        eg - [4, 3, 2, 7, 8, 2, 3, 1]

        - Now as elements will be between 1 - 8, we can consider these values as indexes and visit them start marking out visited elements as -ve.
        - If element is already marked don't do anything about it.
        - After marking check which elements are +ve and there index + 1 are missing elements

*/
