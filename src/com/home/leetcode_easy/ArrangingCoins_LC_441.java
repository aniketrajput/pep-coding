package com.home.leetcode_easy;
/*

You have n coins, and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins.
The last row of the staircase may be incomplete.
Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
        Input: n = 5
        Output: 2
        Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
        Input: n = 8
        Output: 3
        Explanation: Because the 4th row is incomplete, we return 3.

Constraints:
        1 <= n <= 231 - 1

*/


public class ArrangingCoins_LC_441 {

    //O(N)
    public int arrangeCoins1(int n) {
        int i = 1;
        int ans = 0;

        while (n >= i) {
            n = n - i;
            i++;
            ans++;
        }

        return ans;
    }

    //O(logn)
    public int arrangeCoins2(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long k = mid * (mid + 1) / 2;

            if (k == n) {
                return (int) mid;
            }
            else if (k < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return (int) right;
    }

    //O(1)
    public int arrangeCoins3(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

}

/*

Linear approach - O(n)

        Input - N = 6
        Subtract coin on each step (iteration) and calculate N, also keep count of levels completed.

Better approach - O(logn)

        1 + 2 + 3 + 4 .... + n  =>  n (n + 1) / 2

        We have to use following expression and find maximum value of K using binary search =>

        K (K + 1) / 2 <= N		//K is number of complete steps and N is number of given coins

        N = 6

            1 step => C0IN
            2 step => C0IN C0IN
            3 step => C0IN C0IN C0IN

            1 + 2 + 3 <= N				complete steps will always be <= N
            3 (2) / 2 <= N
            3 <= N

        N = 8

            1 step => C0IN
            2 step => C0IN C0IN
            3 step => C0IN C0IN C0IN
            4 step => C0IN C0IN

            1 + 2 + 3 <= N		=> don't take 4 because it is incomplete step
            3 (2) / 2 <= N
            3 <= N


        N = 11

        Possible values of K =

            0 1 2 3 4 5 6 7 8 9 10 11

        Now apply binary search on above

        Algorithm =
        - Initialize left to 0, right to n and k and mid
        - While left <= right
            - calculate mid
                mid = left + (right - left) / 2
            - calculate k
                k = mid * (mid + 1) / 2
            - if k == n
                return mid;
            - if k < n
				left = mid + 1
            - else
                right = mid - 1
        - return right

More Better approach - O(1)

        K (K + 1) / 2 <= N
    =>  K^2 + K <= 2N
    =>  K^2 + K - 2N <= 0
    =>  K <= squareRoot(2N + 1/ 4) - 1 / 2

*/

