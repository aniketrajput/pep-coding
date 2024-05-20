package com.home.arrays_and_string_level_2;

/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

Example 1:
    Input: n = 12
    Output: 21

Example 2:
    Input: n = 21
    Output: -1

Constraints:
    1 <= n <= 231 - 1

Check notebook for explanation.

*/

public class NextGreaterElement_III_LC_556 {

    public static int nextGreaterElement(int n) {
        char[] chArr = ("" + n).toCharArray();              //we can also use - char arr[] = (Integer.toString(n)).toCharArray();

        //find first dip
        int i = chArr.length - 2;
        while (i >= 0 && chArr[i] >= chArr[i+1]) {
            i--;
        }

        if (i == -1) {
            return -1;
        }

        //find just greater than ith index element
        int k = chArr.length - 1;
        while (k > i && chArr[k] <= chArr[i]) {
            k--;
        }

        //swap elements at i and k
        char temp = chArr[i];
        chArr[i] = chArr[k];
        chArr[k] = temp;

        //create a result string from 0 to ith index
        StringBuilder resultStr = new StringBuilder("");
        for (int j = 0; j <= i; j++) {
            resultStr.append(chArr[j]);
        }

        for (int j = chArr.length - 1; j > i; j--) {
            resultStr.append(chArr[j]);
        }

        long result = Long.parseLong(resultStr.toString());             //Here if we do Integer.parseInt for result which is out of Integer range we get Number format exception. So get it in long and check if it exceeds integer max value, if yes return -1
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}
