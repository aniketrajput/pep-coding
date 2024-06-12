package com.home.leetcode_medium;

/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]

Example 2:
        Input: candidates = [2,5,2,1,2], target = 5
        Output:
        [
        [1,2,2],
        [5]
        ]

Constraints:
        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30

*/


//https://www.youtube.com/watch?v=G1fRTGRxXU8&t=144s


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_LC_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(resultList, new ArrayList<>(), candidates, target, 0);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] candidates, int remaining, int start) {

        if (remaining < 0) {
            return;
        }
        else if (remaining == 0){
            resultList.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = start; i < candidates.length; i++) {

                if (i > start && candidates[i] == candidates[i - 1]){           //this will not allow to form duplicate combinations, dry run for input - [1, 1, 1, 2, 2] - and check below youtube
                    continue;
                }

                tempList.add(candidates[i]);

                backtrack(resultList, tempList, candidates, remaining - candidates[i], i + 1);      //not i + 1 because we reuse same elements

                tempList.remove(tempList.size() - 1);
            }
        }
    }
}



//https://www.youtube.com/watch?v=G1fRTGRxXU8&t=144s


