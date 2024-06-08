package com.home.leetcode_easy;
/*

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Example 1:
        Input: cost = [10,15,20]
        Output: 15
        Explanation: You will start at index 1.
        - Pay 15 and climb two steps to reach the top.
        The total cost is 15.

Example 2:
        Input: cost = [1,100,1,1,1,100,1,1,100,1]
        Output: 6
        Explanation: You will start at index 0.
        - Pay 1 and climb two steps to reach index 2.
        - Pay 1 and climb two steps to reach index 4.
        - Pay 1 and climb two steps to reach index 6.
        - Pay 1 and climb one step to reach index 7.
        - Pay 1 and climb two steps to reach index 9.
        - Pay 1 and climb one step to reach the top.
        The total cost is 6.

Constraints:
        2 <= cost.length <= 1000
        0 <= cost[i] <= 999

*/

public class MinCostClimbingStairs_LC_746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];      //dp will store minimum cost taken to reach a step

        if (n<=2) return Math.min(dp[0], dp[1]);

        dp[0] = cost[0];            //0 index will store cost taken to reach step 1
        dp[1] = cost[1];            //1 index will store cost taken to reach step 2

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);     //consider i = 2, then dp[2] will store minimum cost taken to reach step 3. So we can either take step 1 and then go to step 3, or we can take step 2 and then go to step 3, So we will decide whether to take step 1 or 2 depending on min cost, we step 1 cost is min than step 2 then we will take step 1 and then 3, if cost of step 2 is min than step 1 then we will take step 2 and then 3
        }

        return Math.min(dp[n-1], dp[n-2]);      //on the top we can reach either by taking last step and then on top directly or second last step and then on top directly. So which ever is minimum we will take that.
    }

    //Above space complexity is O(N) can reduce it to O(1)

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        if (n<=2)
            return Math.min(first, second);
        for (int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }
}

/*


We start at either step 0 or step 1. The target is to reach either last or second last step, whichever is minimum.

Step 1 - Identify a recurrence relation between subproblems. In this problem,
Recurrence Relation:

        mincost(i) = cost[i] + min(mincost(i-1), mincost(i-2))

Base cases:
        mincost(0) = cost[0]
        mincost(1) = cost[1]

Step 2 - Convert the recurrence relation to recursion

            // Recursive Top Down - O(2^n) Time Limit Exceeded

            public int minCostClimbingStairs(int[] cost) {
                    int n = cost.length;
                    return Math.min(minCost(cost, n-1), minCost(cost, n-2));
            }

            private int minCost(int[] cost, int n) {
                    if (n < 0) return 0;
                    if (n==0 || n==1) return cost[n];

                    return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
            }

Step 3 - Optimization 1 - Top Down DP - Add memoization to recursion - From exponential to linear.

    // Top Down Memoization - O(n) 1ms

            int[] dp;

            public int minCostClimbingStairs(int[] cost) {
                int n = cost.length;
                dp = new int[n];
                return Math.min(minCost(cost, n-1), minCost(cost, n-2));
            }

            private int minCost(int[] cost, int n) {
                if (n < 0) return 0;
                if (n==0 || n==1) return cost[n];

                if (dp[n] != 0) return dp[n];               //if present in dp, return from there no need to make another recursive call.

                dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));

                return dp[n];
            }

Step 4 - Optimization 2 -Bottom Up DP - Convert recursion to iteration - Getting rid of recursive stack

        // Bottom up tabulation - O(n) 1ms

        public int minCostClimbingStairs(int[] cost) {
                int n = cost.length;
                int[] dp = new int[n];

                for (int i=0; i<n; i++) {
                    if (i<2)
                       dp[i] = cost[i];
                    else
                        dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
                }

               return Math.min(dp[n-1], dp[n-2]);
        }

Step 5 - Optimization 3 - Fine Tuning - Reduce O(n) space to O(1).

        // Bottom up computation - O(n) time, O(1) space
        public int minCostClimbingStairs(int[] cost) {
                int n = cost.length;
                int first = cost[0];
                int second = cost[1];

                if (n<=2)
                    return Math.min(first, second);
                for (int i=2; i<n; i++) {
                    int curr = cost[i] + Math.min(first, second);
                    first = second;
                    second = curr;
                }

                return Math.min(first, second);
        }

*/















