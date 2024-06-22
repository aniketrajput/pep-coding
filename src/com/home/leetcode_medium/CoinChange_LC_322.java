package com.home.leetcode_medium;
/*

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3

        Explanation: 11 = 5 + 5 + 1

Example 2:
        Input: coins = [2], amount = 3
        Output: -1

Example 3:
        Input: coins = [1], amount = 0
        Output: 0

Constraints:
        1 <= coins.length <= 12
        1 <= coins[i] <= 231 - 1
        0 <= amount <= 104

*/

public class CoinChange_LC_322 {

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];

        //check edge case
        if (amount < 1) {
            return 0;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

}

/*

Brute Force -
	We will try all the possible combinations of all these coins
	Then from all the combinations find which combination is taking minimum number of coins

Greedy Approach (Gives wrong answer in some scenarios) -
	I want minimum coins, so I will be greedy and try to choose the coin with maximum denomination first

	Example 1 - Correct answer -

		coins => 1 2 5  	amount => 11

		Being greedy we will pick maximum denomination - 5
			11 - 5 => 6
		again pick 5 =>  6 - 5 => 1
		pick 1	=> 1 - 1 = 0

		3 coins => answer

	Example 2, gives wrong answer =>

		coins => 1 5 6 9 	amount => 11

		9 => 11 - 9 => 2
		1 => 2 - 1 = 1
		1 => 1 - 1 = 0

		This will give 3 coins as answer, but actual answer should be 2 (5, 6)

Efficient Solution (Dynammic Programming) -

	We will create a memoization array.

	Example -

		coins => 1 5 6 9 	amount => 11

		amount 				 =>	     [0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9]  [10]  [11]

		min coins needed    =>     [blank] o   oo   ooo  oooo  o    o    oo   ooo  o    oo    oo (answer)		=> o represents coin
		(we will store min
		no of coins need,
		eg for [1] we will store
		min no of coins needed
		to make amount 1)


		amount to make => 6
		coin choices  => 1 1-coin  => 1 |   1 5-coin => 1  |   1 6-coin => 1
		remainder  	   => 5	  		 	|   1	  		   |   0


		amount to make => 6
		coin choices  => 1 1-coin + 1 5-coin  => 2   |  1 5-coin + 1 1-coin => 2	|   1 6-coin + 0 0-coin => 1
		remainder  	   => 0	  				   		 |   0	  						|   0

		So to make amount 6 => min(2, 2, 1) => 1 coin is needed

	Time complexity = O(m * n)	=> m is total number of different coins and n is total amount we to make
	Space complexity = O(n) => Because this is the array space we need to memoize

*/
