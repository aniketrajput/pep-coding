package com.home.arrays_and_string_level2;

/*
Given an integer array of size n, find all elements that appear more than [ n/3 ] times and return it in an arraylist.
Note: Solve the problem in linear time and in O(1) space.

Example 1:
    Input: nums = [3,2,3]
    Output: [3]

Example 2:
    Input: nums = [1]
    Output: [1]

Example 3:
    Input: nums = [1,2]
    Output: [1,2]

-------------------------------------------------------------------------------------------------------------------------
Check notebook for analysis.

More than n/2 frequency element - only one such element is possible
More than n/3 frequency element - only two such elements are possible

An element can be a majority element only if it appears more than floor(n/3) times, i.e it should appear atleast n/3 + 1 time ( one more than n/3 ). Only two such elements are possible in an array.

*/

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_2_LC_229 {
    public static List<Integer> majorityElement(int[] nums) {       //value1 and value2 will be potential candidates
        ArrayList<Integer> resultArr = new ArrayList<>();
        int value1 = nums[0];
        int count1 = 1;
        int value2 = nums[0];
        int count2 = 0;         //keep this count as 0 as for 1st iteration we don't look for second element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value1) {
                count1++;
            } else if (nums[i] == value2) {
                count2++;
            } else {
                if (count1 == 0) {
                    value1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    value2 = nums[i];
                    count2 = 1;
                } else {            //creating a pair of three elements, value1, value2 and nums[i]
                    count1--;
                    count2--;
                }
            }
        }

        if (isMajority(nums, value1)) {
            resultArr.add(value1);
        }

        if (value1 != value2 && isMajority(nums, value2)) {
            resultArr.add(value2);
        }

        return resultArr;
    }

    private static boolean isMajority(int[] nums, int value) {
        int occurrence = 0;

        for (int i = 0; i < nums.length; i++) {
            if (value == nums[i]) {
                occurrence++;
            }
        }

        return occurrence > nums.length/3;
    }

}
