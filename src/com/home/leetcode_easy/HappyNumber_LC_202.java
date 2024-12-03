package com.home.leetcode_easy;
/*

Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
        - Starting with any positive integer, replace the number by the sum of the squares of its digits.
        - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        - Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
        Input: n = 19
        Output: true

        Explanation:
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1

Example 2:
        Input: n = 2
        Output: false

Constraints:
        1 <= n <= 231 - 1

*/

/*

https://www.youtube.com/watch?v=LkD0D0Xy-ro

loop detector - HashSet - keep inserting in HashSet, if same number comes we have found a loop

Time - O(1)
Space - O(1)

Because no matter how big our integer is even if it is 2^31 we will never have sum of digits i.e. more than 1000,
(2^31 = 2147483648 => 2^2 + 1^2 + 4^2 .... this sum will not exceed 1000) So we are doing all calculation in a limited space i.e. Order of 1000 and that is constant space and constant time so O(1)

*/


import java.util.HashSet;

public class HappyNumber_LC_202 {

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (true) {
            int sum = 0;

            while (n != 0) {
                sum = (int) (sum + Math.pow(n % 10, 2.0));
                n = n / 10;
            }

            if (sum == 1)
                return true;

            n = sum;

            if (hashSet.contains(n))
                return false;

            hashSet.add(n);
        }
    }

}























