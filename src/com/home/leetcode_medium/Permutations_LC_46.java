package com.home.leetcode_medium;

/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
        Input: nums = [0,1]
        Output: [[0,1],[1,0]]

Example 3:
        Input: nums = [1]
        Output: [[1]]

Constraints:
        1 <= nums.length <= 6
        -10 <= nums[i] <= 10
        All the integers of nums are unique.

*/

import java.util.ArrayList;
import java.util.List;

public class Permutations_LC_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {

        //If we match the length, it is a permutation
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //Skip if we get same element
            if (tempList.contains(nums[i])) {
                continue;
            }

            //Add the new element
            tempList.add(nums[i]);

            //Go back to try other element
            backtrack(resultList, tempList, nums);

            //Remove the element
            tempList.remove(tempList.size() - 1);           //This is where backtracking is happening, we remove element which was used in previous call and try remaining
        }
    }
}

/*

- Permutation simply means, in all the different ways you can arrange the elements.
- We cannot have an arrangement where we are taking the same element more than once or duplicating the elements, and also we cannot exceed the original length of given array.
        Example - if given is [1, 2, 3] then we cannot have [3, 3, 1] or [3, 3, 1, 2]

- If given is [1, 2, 3] then,
        3 (1st place 3 character or numbers can be placed) * 2 (2nd place 2 character or numbers can be placed as 1 character will be placed already) * 1 (3rd place 1 character can be placed as 2 are already placed) => 3 * 2 * 1 => 6

        So total 6 permutations will be possible

        So if there are n unique elements, then there will be n! permutations

- Check notebook for diagram

- Iterate over each character
    For each character:
        - start to pick the 1st character
        - go back
        - try picking the next

- Do dry run of the code, check notebook dry run is done


Time complexity -
	- An array of size n will have n! permutations and to calculate those permutations we need to traverse the array n times, so time complexity =
		O[(n!) * n]

Space complexity = O(n) where n is stack space we are choosing


*/
