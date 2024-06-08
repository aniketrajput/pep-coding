package com.home.leetcode_easy;
/*

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Example 1:
        Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
        Output: [-1,3,-1]

        Explanation: The next greater element for each value of nums1 is as follows:
        - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
        - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
        - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

Example 2:
        Input: nums1 = [2,4], nums2 = [1,2,3,4]
        Output: [3,-1]

        Explanation: The next greater element for each value of nums1 is as follows:
        - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
        - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

Constraints:
        1 <= nums1.length <= nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 104
        All integers in nums1 and nums2 are unique.
        All the integers of nums1 also appear in nums2.


Follow up: Could you find an O(nums1.length + nums2.length) solution?

*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I_LC_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] resultArr = new int[nums1.length];

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {    //if current element is greater than stack.peek() then current element is next greater of previous element stored in stack
                hashMap.put(stack.pop(), num);
            }

            stack.push(num);    //need to find next greater element for num as well, right, so put it in stack and in next iterations we might get next greater element for num. So basically in stack we store elements for which we want to find next greater element
        }

        for (int i = 0; i < nums1.length; i++) {
            resultArr[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return resultArr;
    }
}

/*

Brute Force -
    Iterate nums1 and have have a nested loop on nums2 and check for each element

Optimal Solution -
    - In Hashmap have next greater elements for all nums2 elements
    - Then iterate nums1 and get next greater element from hashmap
    - We will need stack to help us

    Approach:
        - The idea here is to create a map which will have the mapping of each element from the bigger array (nums2[]) and its corresponding greater element. In order to do that we are using a monotone stack in increasing order (top element is smaller than the element below in the stack).

    Algorithm:
        - We iterate through nums2[] and push each element into a stack.
        - If the current element in the iteration is greater than the top most element in the stack, then we pop it out and add the popped out element as key and the current element as the value (next greater number).
        - We repeat this process as long as the current element is greater than the top most element in the stack or the stack is empty.
        - The current element is also added to the stack.
        - The last element in the nums2[] will not have a next element. Hence we are not adding that to the map.
        - Similarly if there are elements in the stack which does not have a next greater element, remains in the stack and is not moved to the map as the requirement for these elements is to default it to -1, which is being taken care while fetching values from the map.

*/





















