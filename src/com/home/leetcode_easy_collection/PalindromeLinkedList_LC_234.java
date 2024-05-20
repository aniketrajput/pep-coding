package com.home.leetcode_easy_collection;
/*

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
        Input: head = [1,2,2,1]
        Output: true

Example 2:
        Input: head = [1,2]
        Output: false

Constraints:
        The number of nodes in the list is in the range [1, 105].
        0 <= Node.val <= 9

        Follow up: Could you do it in O(n) time and O(1) space?
*/

/*

Solution using Stack -
        - Find the mid of LL.
        - Iterate the LL and till middle node of LL push node data in stack.
        - After middle node, pop from stack and check if popped data is equal to current node's data.
        - Here actual LL structure will not change


Space optimized solution -  		O(n) time and O(1) space
        - Divide LL from middle node and create two separate LLs
        - Reverse the second LL
        - Compare both the LLs nodes, if un-matching node found then return false
        - If LL has odd number of nodes, then leave the middle node and then create two separate LL without middle node.
        - Here actual LL structure will change

*/


public class PalindromeLinkedList_LC_234 {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {         //find middle node. observe &&, || will throw NPE, as it will go inside loop even when fast.next is null
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {     //odd number of nodes are there, we will keep the middle node in 1st LL
            slow = slow.next;
        }

        slow = reverseLinkedList(slow);
        fast = head;

        while (slow != null) {      //In case of odd number of node, 2nd LL will end first, and we don't want to check last node in 1st LL
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

}



























