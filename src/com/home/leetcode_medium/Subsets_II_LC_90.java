package com.home.leetcode_medium;

/*

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
        Input: nums = [1,2,2]
        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
        Input: nums = [0]
        Output: [[],[0]]

Constraints:
        1 <= nums.length <= 10
        -10 <= nums[i] <= 10

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_LC_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);          //Arrays.sort(nums) = this will help in grouping together duplicate elements input array together, and the subsets which will be created using this sorted array will have duplicates in same sequence or same order, which will help in identifying them in result list and avoid adding them again in result list

        //Start backtracking from the beginning
        backtrack(resultList, new ArrayList<Integer>(), nums, 0);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums, int start) {

        //If the set is already present, just continue
        if (resultList.contains(tempList))
            return;

        //Add the set to resultList
        resultList.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {

            //Case of including the number
            tempList.add(nums[i]);

            //Backtrack the new subset
            backtrack(resultList, tempList, nums, i + 1);

            //Case of not-including the number
            tempList.remove(tempList.size() - 1);
        }
    }

}

/*

This time arrays can have duplicate elements as well.
We need to make sure we remove all duplicates from the result list.

Example -
        Input - [1, 2, 2]

        Subsets - [], [1], [2], [1, 2], [2, 2], [1, 2, 2]

        Following will be duplicates - [2, 1, 2], [2, 2, 1], [2, 1]

Arrays.sort(nums) = this will help in grouping together duplicate elements input array together, and the subsets which will be created using this sorted array will have duplicates in same sequence or same order, which will help in identifying them in result list and avoid adding them again in result list

As we are just adding an if-condition here, the time and space complexity will be same as original problem.

*/
