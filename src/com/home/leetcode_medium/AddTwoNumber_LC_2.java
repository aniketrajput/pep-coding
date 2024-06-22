package com.home.leetcode_medium;
/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]

        Explanation: 342 + 465 = 807.

Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]

Example 3:
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]

Constraints:
        The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
        It is guaranteed that the list represents a number that does not have leading zeros.

*/

public class AddTwoNumber_LC_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0 + carry;

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }

        return result.next;
    }

}

/*

Gotchas to keep in mind while solving -
    - We need to worry about 0s in front and not 0s at the start.

        Example 1 =  4 -> 9 -> 9 -> 5 -> 9 -> 0    => 0 9 5 9 9 4

        Example 2 = 0 -> 4 -> 9 -> 9 -> 5 -> 9    => 9 5 9 9 4 0

    - Take care of Integer limit, what if LL has thousands of elements

    - We need to take care of extra node that might get added in result.

        Example => 99 + 9 = 108

Defining a Solution -
    - We will have two pointers starting from head of each LL
    - We start adding from them - when we add numbers we add from last digits, so in LL last digits will start from head, as we need to consider number in reverse.
    - Maintain two variables sum and carry


     Time complexity will be - O(n), where n will be length of larger LL.
     Space complexity - O(n) as there could be n nodes in result LL.

*/





















