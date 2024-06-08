package com.home.leetcode_easy;
/*

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

        Example 2:
        Input: list1 = [], list2 = []
        Output: []

        Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]

        Constraints:
        The number of nodes in both lists is in the range [0, 50].
        -100 <= Node.val <= 100
        Both list1 and list2 are sorted in non-decreasing order.

*/

public class MergeTwoSortedList_LC_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode endPtr = null;

        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        while (list1 != null && list2 != null) {
            if (head == null) {
                if (list1.val < list2.val) {
                    head = list1;
                    endPtr = list1;
                    list1 = list1.next;
                }
                else {
                    head = list2;
                    endPtr = list2;
                    list2 = list2.next;
                }
                continue;
            }

            if (list1.val < list2.val) {
                endPtr.next = list1;
                endPtr = list1;
                list1 = list1.next;
            }
            else {
                endPtr.next = list2;
                endPtr = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            endPtr.next = list1;
        }
        else if (list2 != null) {
            endPtr.next = list2;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}