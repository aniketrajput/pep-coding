package com.home.leetcode_easy_collection;

/*

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
        Input: head = [1,1,2]
        Output: [1,2]

Example 2:
        Input: head = [1,1,2,3,3]
        Output: [1,2,3]

Constraints:
        The number of nodes in the list is in the range [0, 300].
        -100 <= Node.val <= 100
        The list is guaranteed to be sorted in ascending order.

*/

public class RemoveDuplicatesFromSortedList_LC_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = head;
        ListNode temp = prev.next;

        while (temp != null) {
            if (prev.val == temp.val) {
                temp = temp.next;
                continue;
            }

            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;           //suppose at the end temp reaches null or end of the list, but there were duplicates between prev and temp. eg - 1 -> 2 -> 2 -> 3 -> 4 -> 4

        return head;
    }

}

/*

Brute Force -
    - Use Set, add elements in set and then create new list using set.
    - If list is very large, we would be creating an extra space in set with same number, So space complexity O(n)

Efficient Solution -
    - Use fact that it is a LL, take advantage of it. You can modify pointers as you like
    - It is sorted - duplicate elements will be next to each other

*/
