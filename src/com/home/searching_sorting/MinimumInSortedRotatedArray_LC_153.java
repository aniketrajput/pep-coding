package com.home.searching_sorting;

public class MinimumInSortedRotatedArray_LC_153 {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if(nums[low] <= nums[high]) {
            //array is sorted and no rotation is there, so arr[0] is miniumum - [10, 12, 13, 14, 15, 16]
            return nums[0];
        }

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] > nums[mid + 1]) {       //If we are at last element of sorted part. Write this condition first because in following case it will fail if below condition is written first due to nums[mid - 1]
                return nums[mid + 1];
            }
            else if (nums[mid] < nums[mid - 1]) {       //If we are at first element of unsorted second part
                return nums[mid];
            }
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else if (nums[mid] <= nums[high]) {
                high = mid - 1;
            }
        }

        return -1;
    }
}
