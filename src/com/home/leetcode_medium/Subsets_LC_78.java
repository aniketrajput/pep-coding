package com.home.leetcode_medium;

/*

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
        Input: nums = [0]
        Output: [[],[0]]

Constraints:
        1 <= nums.length <= 10
        -10 <= nums[i] <= 10
        All the numbers of nums are unique.

*/

import java.util.ArrayList;
import java.util.List;

public class Subsets_LC_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        //Start backtracking from the beginning
        backtrack(resultList, new ArrayList<Integer>(), nums, 0);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums, int start) {

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

Subset - is nothing but a smaller set that you can derive from a larger set and this set can have one or all of the elements from an array.

Example -
        Input => [1, 2, 3]
        Subsets => [], [1], [2], [3], [1, 2], [1, 3], [2, 3], , [1, 2, 3]

        We cannot have subsets like [3, 1] because it is same as [1, 3]

Brute Force -

        [1, 2, 3, 4]

        2 (We have 2 choices, either it will have 1 or won't have 1) * 2 (We have 2 choices, either it will have 2 or won't have 2) * 2 (We have 2 choices, either it will have 3 or won't have 3) * 2 (We have 2 choices, either it will have 4 or won't have 4) => 16 (subsets possible)

        So, number of possible subsets => 2 ^ n (where n is number of elements in array)

        We can start by considering subsets that will always have 1, then subsets that will always have 2, and so on. Later we can remove duplicate subsets.

Backtracking to find a solution -

        Check diagram in notebook.

        Time Complexity - Each element can either be included or it cannot, hence, 2 ^ n and we have total of n elements so O[n(2 ^ n)]
        Space Complexity - O(n), as we are taking up stack space to store O(n) elements.

*/
