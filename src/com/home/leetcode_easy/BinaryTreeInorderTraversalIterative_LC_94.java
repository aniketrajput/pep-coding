package com.home.leetcode_easy;

/*

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
        Input: root = [1,null,2,3]
        Output: [1,3,2]

Example 2:
        Input: root = []
        Output: []

Example 3:
        Input: root = [1]
        Output: [1]

Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalIterative_LC_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if (stack.isEmpty()) {
                    break;
                }

                node = stack.pop();
                inOrder.add(node.val);
                node = node.right;
            }
        }

        return inOrder;
    }

    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        helper(inOrder, root);
        return inOrder;
    }

    private void helper(List<Integer> inOrder, TreeNode root) {
        if (root == null)
            return;

        helper(inOrder, root.left);
        inOrder.add(root.val);
        helper(inOrder, root.right);
    }

}

//Manage your own stack





