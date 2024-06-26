package com.home.leetcode_easy;
/*

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

        Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

        Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.

        Constraints:
        1 <= prices.length <= 105
        0 <= prices[i] <= 104


If you are selling on ith day, you buy on the minimum price from 1st day - (i - 1) day

*/


public class BestTimeToBuySellStock_LC_121 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPriceSoFar = prices[0];       //for 2nd day 1st day price will be minimum

        for (int i = 1; i < prices.length; i++) {           //start from 1
            int profitNow = prices[i] - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profitNow);

            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }

        return maxProfit;
    }

}
