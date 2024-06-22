package com.home.leetcode_medium;

/*

Given an integer array nums, return the length of the longest strictly increasing subsequence

Example 1:
        Input: nums = [10,9,2,5,3,7,101,18]
        Output: 4

        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
        Input: nums = [0,1,0,3,2,3]
        Output: 4

Example 3:
        Input: nums = [7,7,7,7,7,7,7]
        Output: 1

Constraints:
        1 <= nums.length <= 2500
        -104 <= nums[i] <= 104

*/

public class LongestIncreasingSubsequence_LC_300 {

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        return dp[maxIndex] + 1;
    }
}

/*

Subsequence - means you are picking elements from array, and they need not be contiguous.

Brute Force approach & Recursive solution -
    We can start from 0th index and start finding subsequences one by one.
    Keep count of max length subsequence.

    Recursive -
        For each index, we have decision to make, where to pick it in result subsequence or don't pick it.
        We might compute duplicates


Dynammic Programming, Using Memoization -

    - We will take help of additional array
    - Initially we put 1 as value for all indexes - it indicates that for each index the length of the longest increasing subsequence will be at least 1.
        We can have initial initialization as 0 as well (default) but while returning answer we will do + 1.
    - The value in this array will represent - the length of the LIS ending at that index.

    - If element at j < element at i, then length of LIS at i, is at least 1 greater than length of LIS at j.
        - initially j will point at 0 and i at 1
        - i will be fixed till j becomes equal to i, and we check if element at j < element at i
        - If condition is satisfied, we get LIS at j, add 1, and set it to LIS at i. Note we are saying at least above, if j < i (j is behind i) and if there is some more elements who are smaller than element at i, then LIS can increase accordingly.
        - when j becomes equal to i we move j back to 0th index and move i at i = i + 1 and continue same until i = n
    - If element at j > element at i, then don't do anything.


    Part of dry - run =>

                    j     i
nums  =>    [3  4  -1  0  6  2  3]
dp[]  =>    [1  2   1  2  3  1  2]

            Here -1 < 6, so dp[j] + 1 = 2 but dp[i] is 3, so ignore...
            here in length 2 we are considering subsequence [-1 6]. It says I am -1, there is no one before me who can join us, and I don't know if anyone will join after me, now only I can join 6

            Next iteration -

                       j  i
nums  =>    [3  4  -1  0  6  2  3]
dp[]  =>    [1  2   1  2  3  1  2]

            Here 0 < 6, so dp[j] + 1 = 3 but dp[i] is also 3, so ignore...
            here in length 3 we are considering subsequence [-1 0 6]. It says I am 0, I can bring -1 who is before me and join us
*/



























