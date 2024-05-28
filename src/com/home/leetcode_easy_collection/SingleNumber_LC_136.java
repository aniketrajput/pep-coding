package com.home.leetcode_easy_collection;
/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
        Input: nums = [2,2,1]
        Output: 1

Example 2:
        Input: nums = [4,1,2,1,2]
        Output: 4

Example 3:
        Input: nums = [1]
        Output: 1

Constraints:
        1 <= nums.length <= 3 * 104
        -3 * 104 <= nums[i] <= 3 * 104

Each element in the array appears twice except for one element which appears only once.

*/

public class SingleNumber_LC_136 {

    public int singleNumber(int[] nums) {
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            answer = answer ^ nums[i];
        }

        return answer;
    }

}


/*

Brute force -
        Take each element and check if it is occurring again ahead in array.
        Time - O(n ^2)

Using Frequency Map -
        Get frequency map in hashmap
        Scan hashMap for frequency one
        Time - O(N)
        Space - O(N) as extra space taken and worst case all elements will be stored

Sorting -
        Sort first
        Problem statement states that every element appears twice except one.
        Compare the adjacent elements, one element will not have a pair

        Time - sort will take - O(nlogn)
        Space - O(1)

Using Set -
        Insert elements in set - to get unique elements
        Problem statement states that every element appears twice except one.
        So if we sum each unique element taking them twice - the sum of input array elements = answer (missing element)
        Time - O(N)
        Space - O(N) as extra space taken and worst case all elements will be stored

Using bitwise operator XOR(^) -

        A ^ A = 0
        A ^ 0 = A
        A ^ B ^ C = A ^ C ^ B

        0 ^ 0 = 0
        1 ^ 0 = 1
        0 ^ 1 = 1
        1 ^ 1 = 0

        When bits are same it will be 0
        When not same then 1

        2 ^ 2 => it will do binary ^ operation =>

            0 0 1 0
        ^	0 0 1 0
            ----------
            0 0 0 0

     Example 1 -
        input => 1 1 2

        1 ^ 1 = 0
        0 ^ 2 = 2

        So 2 is answer

     Example 2 -
        input => 1 2 1 2 4

        1 ^ 2 => something(don't worry about this something)
        1 ^ 2 ^ 1 =>
        1 ^ 1 ^ 2 =>
        0 ^ 2 => 2

        2 ^ 2 = 0
        0 ^ 4 => 4

    Time - O(n)
    Space - O(1)
    
*/
