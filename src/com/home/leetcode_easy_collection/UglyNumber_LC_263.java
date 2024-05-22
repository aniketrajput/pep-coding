package com.home.leetcode_easy_collection;
/*

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
        Input: n = 6
        Output: true
        Explanation: 6 = 2 × 3

Example 2:
        Input: n = 1
        Output: true
        Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

Example 3:
        Input: n = 14
        Output: false
        Explanation: 14 is not ugly since it includes the prime factor 7.

Constraints:
        -231 <= n <= 231 - 1

*/

public class UglyNumber_LC_263 {

    public boolean isUgly(int n) {
        if (n <= 0)
            return false;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            }
            else if (n % 3 == 0) {
                n = n / 3;
            }
            else if (n % 5 == 0) {
                n = n / 5;
            }
            else {
                break;
            }
        }

        if (n == 1) {
            return true;
        }
        else {
         return false;
        }
    }
}

/*

Iterate until n !=  1

        i) if(n % 2 == 0)
        n = n/2

        ii) if(n % 3 == 0)
        n = n/3

        iii) if(n % 5 == 0)
        n = n/5

If n becomes 1 then it is ugly number

20 is also ugly number - 2, 5, 2	Factor should be amongst 2, 3, 5

*/
