package com.home.leetcode_medium;

/*

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    - Only numbers 1 through 9 are used.
    - Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
        Input: k = 3, n = 7
        Output: [[1,2,4]]

        Explanation:
        1 + 2 + 4 = 7
        There are no other valid combinations.

Example 2:
        Input: k = 3, n = 9
        Output: [[1,2,6],[1,3,5],[2,3,4]]

        Explanation:
        1 + 2 + 6 = 9
        1 + 3 + 5 = 9
        2 + 3 + 4 = 9
        There are no other valid combinations.

Example 3:
        Input: k = 4, n = 1
        Output: []

        Explanation: There are no valid combinations.
        Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

Constraints:
        2 <= k <= 9
        1 <= n <= 60

*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_III_LC_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), k, n, 1);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int k, int remaining, int start) {

        if (tempList.size() > k) {
            return;
        }
        else if (tempList.size() == k && remaining == 0){
            resultList.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);

                backtrack(resultList, tempList, k, remaining - i, i + 1);      //not i + 1 because we reuse same elements

                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


