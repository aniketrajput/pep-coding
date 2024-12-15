package com.home.leetcode_easy;
/*

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
        Input: x = 123
        Output: 321

Example 2:
        Input: x = -123
        Output: -321

Example 3:
        Input: x = 120
        Output: 21

Constraints:
        -2^31 <= x <= 2^31 - 1
*/


public class ReverseInteger_LC_7 {

    public int reverse(int x) {
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        long answer = 0;

        while (x != 0) {
            int remainder = x % 10;
            answer = answer * 10 + remainder;
            x = x / 10;
        }

        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
            return 0;
        }

        if (isNegative) {
            answer = -answer;
        }

        return (int) answer;
    }

}











