package com.home.leetcode_easy;
/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]


        Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.


        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?



    - Brute force approach	O(N^2)
        Two loops, i = 0
                   j = i + 1

    - Two pointers approach  LogN
        left on 0
        right on arr - 1

        if,
            left + right > target, do right--
            left + right < target, do left++
            left + right == target, we got the target, print, can also do left-- and right++ to find next combinations

        But this approach is good when we need to find two values, in problem we need to find indices so this approach won't work. (check why won't work, left and right are indices only right?)

    - We can create a new array of Pair class.
        class Pair implements Comparable<Pair> {
            int val;
            int index;
        }
        Sort Pair array and use above logic

    - Using HashMap
    We find required_number => target - nums[i]
	If it is not present in HashMap<Value, Index>, add nums[i] and i in HashMap. We are storing elements we traversed in hashMap which might be one of the required pair number
	If it is found in hashMap we have found our pair, current element index and one found in hashMap.

*/

import java.util.HashMap;

public class TwoSum_LC_1 {

    //Brute Force Approach
    /*public int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resultArray[0] = i;
                    resultArray[1] = j;
                    return resultArray;
                }
            }
        }

        return null;
    }*/

    /*public int[] twoSum(int[] nums, int target) {
        Pair[] pairsArr = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pairsArr[i].value = nums[i];
            pairsArr[i].index = i;
        }

        Arrays.sort(pairsArr);          //using Comparable compareTo it will sort

        int left = 0;
        int right = pairsArr.length - 1;
        int[] res = new int[2];

        while (left < right) {
            if (pairsArr[left].value + pairsArr[right].value > target) {
                right--;
            }
            else if (pairsArr[left].value + pairsArr[right].value < target) {
                left++;
            }
            else {
                res[0] = pairsArr[left].index;
                res[1] = pairsArr[right].index;
                break;
            }
        }

        return res;
    }*/

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int required_number = target - nums[i];

            if (hashMap.containsKey(required_number)) {
                return new int[] {hashMap.get(required_number), i};
            }
            else {
                hashMap.put(nums[i], i);
            }
        }

        return null;
    }
}

class Pair implements Comparable<Pair> {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        return this.value - o.value;
    }
}
