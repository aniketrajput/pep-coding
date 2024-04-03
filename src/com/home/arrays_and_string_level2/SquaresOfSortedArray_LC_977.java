package com.home.arrays_and_string_level2;

/*
Check notebook for analysis
*/

public class SquaresOfSortedArray_LC_977 {

    public static int[] sortedSquares(int[] nums) {
        int[] resultArr = new int[nums.length];
        int i = 0;                          //most -ve element
        int j = nums.length - 1;            //most +ve element
        int idx = resultArr.length - 1;

        while (i <= j) {
            int squareI = nums[i] * nums[i];
            int squareJ = nums[j] * nums[j];

            if (squareI > squareJ) {
                resultArr[idx] = squareI;
                i++;
            }
            else {
                resultArr[idx] = squareJ;
                j--;
            }

            idx--;
        }

        return resultArr;
    }
}
