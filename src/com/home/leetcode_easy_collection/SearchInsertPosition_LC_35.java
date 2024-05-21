package com.home.leetcode_easy_collection;
/*

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
        Input: nums = [1,3,5,6], target = 5
        Output: 2

Example 2:
        Input: nums = [1,3,5,6], target = 2
        Output: 1

Example 3:
        Input: nums = [1,3,5,6], target = 7
        Output: 4

Constraints:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums contains distinct values sorted in ascending order.
        -104 <= target <= 104

*/

public class SearchInsertPosition_LC_35 {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}
