package com.home.leetcode_easy;
/*

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]

        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100].

Example 2:

        Input: nums = [-7,-3,2,3,11]
        Output: [4,9,9,49,121]

Constraints:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

*/


public class SquareOfASortedArray_LC_977 {
    public int[] sortedSquares(int[] nums) {
        int[] resultArr = new int[nums.length];

        //Find square of all elements
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int head = 0;
        int tail = nums.length - 1;

        for (int i = resultArr.length - 1; i >= 0; i--) {
            if (nums[head] > nums[tail]) {
                resultArr[i] = nums[head];
                head++;
            }
            else {
                resultArr[i] = nums[tail];
                tail--;
            }
        }

        return resultArr;
    }
}

/*

Brute force -
        Square all - O(N)
        Sort - O(nlogn)

Optimal solution -
        Using two pointers
        We will get sorted solution using two pointers because -
            Suppose we have sorted input array with -ve numbers,
            Then after squaring each number, there will be a point where left side will be sorted and right side will be sorted.
                eg - inputArr = [-7, -4, -1, 2, 3, 6, 10]
                     square =   [49, 16, 1, 4, 9, 36, 100]   - here till 1 we can see array is sorted and after 1 as well array is sorted.
            We know in this case extreme heads will be on left end (head) and right end (tail), so we will check which one is greater and put that at the end of our resultArr.
*/
