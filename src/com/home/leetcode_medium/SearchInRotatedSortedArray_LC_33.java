package com.home.leetcode_medium;

/*

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4

Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1

Example 3:
        Input: nums = [1], target = 0
        Output: -1

Constraints:
        1 <= nums.length <= 5000
        -104 <= nums[i] <= 104
        All values of nums are unique.
        nums is an ascending array that is possibly rotated.
        -104 <= target <= 104

*/


public class SearchInRotatedSortedArray_LC_33 {

    public static int search(int[] nums, int target) {
        return modifiedBinarySearch(nums, target, 0, nums.length - 1);
    }

    private static int modifiedBinarySearch(int[] nums, int target, int left, int right) {

        if (left > right) {     //left will become greater than right when target is not present
            return -1;
        }

        int mid = left + (right - left) / 2;    //Avoid overflow, same as (left + right) / 2

        if (nums[mid] == target) {
            return mid;     //target found
        }

        //check if left half is sorted
        if (nums[left] <= nums[mid]) {

            if (nums[left] <= target && nums[mid] >= target) {
                //target present in left sorted half
                return modifiedBinarySearch(nums, target, left, mid - 1);      //find target in left half
            }
            else {
                //target not present in left sorted half, we need to break the right unsorted part further.
                return modifiedBinarySearch(nums, target, mid + 1, right);
            }
        }
        else {
            //right half is sorted
            if (nums[mid] <= target && nums[right] >= target) {
                //target present in right sorted half
                return modifiedBinarySearch(nums, target, mid + 1, right);
            }
            else {
                //target not present in right sorted half, we need to break the left unsorted part further
                return modifiedBinarySearch(nums, target, left, mid - 1);
            }
        }
    }
}

/*

Note: We have a iterative solution as well in searching_sorting package.

https://www.youtube.com/watch?v=iXLMMbdjeNM&t=290s


        Brute Force -

        - We can un-rotate the array and we will get normal sorted array and then we can perform normal binary search operation.
        - Binary search will take O(n log n) time but un-rotating an array will take O(n) time.
        - We are also not taking the advantage of the fact that this array is sorted.

        Binary search -

        Method 1 - Finding Pivot using binary search.
        - left element will be greater and right element will be smaller
        - If we break the array on pivot we will get two array and both will be sorted then we can apply binary search on both
        - In broken arrays, if first element is larger than the target, then all the remaining elements would be definitely larger, so we won't find target in this array. So we can apply binary search algorithm in second array.

        In this appraoch we take O(log n) time to find pivot element and then again we take O(log n) time to find our target.

        But, here we are applying binary search two times, first to find the pivot element and second to find the target. So we can apply binary search on original array and arrive at an answer.

        Method-2 - Modified Binary Search
        - When we apply binary search on original array, we will get on array which is sorted and another array which is unsorted.
        - Then we can search for target in sorted part of array, if we don't find it there then we are left with other unsorted part of array
        - Then we can again divide unsorted array into two, again we will get one part sorted and another part which is unsorted and again we can apply binary search on sorted part and find target, if still don't find target and repeat same on unsorted part.
        Time complexity will be O(log n)
        This is a recurssive appraoch.

*/





