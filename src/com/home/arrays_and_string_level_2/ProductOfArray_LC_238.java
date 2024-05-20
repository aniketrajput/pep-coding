package com.home.arrays_and_string_level_2;

/*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

Check analysis in notebook.

*/

public class ProductOfArray_LC_238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] rightProductArr = new int[nums.length];
        int rightProduct = 1;

        for (int i = nums.length - 1; i >=0 ; i--) {                //calculate right array
            rightProduct *= nums[i];                                //this line should come first in loop. In right array on each index we store product of all elements to right including that element. So on last index we will include last element.
            rightProductArr[i] = rightProduct;
        }

        int leftProduct = 1;

        for (int i = 0; i < nums.length - 1; i++) {             //iterate till nums.length - 1 i.e. before last element. Because in loop we get i + 1 for right array
            result[i] = leftProduct * rightProductArr[i + 1];
            leftProduct *= nums[i];
        }

        result[nums.length - 1] = leftProduct;                  //last remaining element will be left product before that index as right product will be 1

        return result;
    }

}
