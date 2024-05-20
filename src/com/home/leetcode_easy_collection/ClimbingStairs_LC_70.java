package com.home.leetcode_easy_collection;
/*

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

Example 2:
        Input: n = 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

Constraints:
        1 <= n <= 45

*/

/*

Number of ways to reach step 7 = number of ways to reach 6 + number of ways to reach step 5

Number of ways to reach step n = number of ways to reach n-1 + number of ways to reach step n-2

step[n] = step[n-1] + step[n-2]

*/

public class ClimbingStairs_LC_70 {

    public static int climbStairs(int n) {
        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];              //Here index represents the stairs, and array value will represent number steps to reach current index stair. 0th element means 0th stair it makes no sense so keep its value 0
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
