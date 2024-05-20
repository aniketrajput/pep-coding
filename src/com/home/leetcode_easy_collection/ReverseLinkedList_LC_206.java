package com.home.leetcode_easy_collection;

/*

Given the head of a singly linked list, reverse the list, and return the reversed list.

        Input: head = [1,2,3,4,5]
        Output: [5,4,3,2,1]

        Input: head = [1,2]
        Output: [2,1]

        Input: head = []
        Output: []

        Constraints:
        The number of nodes in the list is the range [0, 5000].
        -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

*/

public class ReverseLinkedList_LC_206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

}
