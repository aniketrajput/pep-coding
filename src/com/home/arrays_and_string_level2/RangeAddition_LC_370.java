package com.home.arrays_and_string_level2;

/*
Check Notebook for analysis and explanation.

Assume you have an array of length 'n' initialized with all 0's and given 'q' queries to update.
Each query is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex...endIndex] (startIndex and endIndex inclusive) with inc.
Return the modified array after all 'q' queries were executed.

Input format -

    length = 5,
    updates =
    {
        {1, 3, 2},
        {2, 4, 3},
        {0, 2, -2}
    }

Output format -

    return {-2, 0, 3, 5, 3}

*/

public class RangeAddition_LC_370 {

    public static int[] getModifiedArray(int length, int[][] queries) {
        int[] resultArr = new int[length];

        for (int i = 0; i < queries.length; i++) {
            int startingIndex = queries[i][0];
            int endingIndex = queries[i][1];
            int increment = queries[i][2];

            resultArr[startingIndex] += increment;      //add impact

            if (endingIndex + 1 < length) {
                resultArr[endingIndex + 1] -= increment;        //remove impact
            }
        }

        int sum = 0;

        for (int i = 0; i < resultArr.length; i++) {    //prefix sum
            sum += resultArr[i];
            resultArr[i] = sum;
        }

        displayResultArr(resultArr);

        return resultArr;
    }

    private static void displayResultArr(int[] resultArr) {
        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }

}
