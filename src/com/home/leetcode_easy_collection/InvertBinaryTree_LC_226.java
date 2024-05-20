package com.home.leetcode_easy_collection;
/*

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]

Example 2:
        Input: root = [2,1,3]
        Output: [2,3,1]

Example 3:
        Input: root = []
        Output: []

Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100

*/

/*
Invert or Mirror or Flip a Binary Tree

        Queue - First In First Out
            Enqueue - inserts at front
            DeQueue - removes from back

        O(n) O(n)


- We are using Level-Order traversing so using queue
- Initially insert root in queue.
- Iterate until queue belows empty.
- While iterating take node out from queue, swap its left and right children, insert children in queue
- In next iteration previously inserted left child will be removed, its left and right children will be swapped and its left and right child will be inserted if those are not null.
- When queue becomes empty all child nodes must have been processed, and we return root


In case of recursive solution we have to maintain the stack in cpu memory

*/


import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_LC_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            //swap children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        return root;
    }

    public TreeNode recursiveSolution(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = recursiveSolution(root.left);
        TreeNode right = recursiveSolution(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}








