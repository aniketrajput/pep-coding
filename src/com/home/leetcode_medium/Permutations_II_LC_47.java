package com.home.leetcode_medium;

/*

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
        Input: nums = [1,1,2]
        Output:
        [[1,1,2],
        [1,2,1],
        [2,1,1]]

Example 2:
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
        1 <= nums.length <= 8
        -10 <= nums[i] <= 10

*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II_LC_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);      // Sort the input array to group duplicates together

        backtrack(resultList, new ArrayList<>(), nums, new boolean[nums.length]);

        return resultList;
    }


    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums, boolean[] used) {

        //If we match the length, it is a permutation
        if (tempList.size() == nums.length && !resultList.contains(tempList)) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //Skip if we get same element
            if (used[i]) {
                continue;
            }

            //Add the new element and mark it as used
            used[i] = true;
            tempList.add(nums[i]);

            //Go back to try other element
            backtrack(resultList, tempList, nums, used);

            //Remove the element and mark it as unused
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

}


/*

- Logic is similar to Permutations_LC_46, here we can have duplicates in given input array set.
    Eg.  [1,1,2]
        Here if we keep previously used if condition then the 1 at 1th index will not be used, and it will be skipped, so we need to manage such cases, so we will use usedFlag array.
   Also we need to one add unique sets in final result, so that we will handle in our base case

*/


