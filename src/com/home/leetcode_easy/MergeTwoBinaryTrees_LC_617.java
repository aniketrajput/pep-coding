package com.home.leetcode_easy;
/*

You are given two binary trees root1 and root2.
Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

Example 1:
        Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        Output: [3,4,5,5,4,null,7]

Example 2:
        Input: root1 = [1], root2 = [1,2]
        Output: [2,2]

Constraints:
        The number of nodes in both trees is in the range [0, 2000].
        -104 <= Node.val <= 104

*/
/*

Solutions -
        1. Recursive (DFS)                  Time - O(N)     Space - O(H)   H - indicates height of the tree to store recursion stack.
            Preorder Traversal
                - Process root
                - Process left tree (Recursive)
                - Process right tree (Recursive)

            As this solution is a recursive, it uses stack memory of the CPU or heap, it can lead to StackOverflow issue. To avoid we can use Iterative approach.

        2. Iterative (DFS)
        3. Iterative (BFS) (Level order traversal)

Conditions -
        If T1 node is null and T2 node is null
            consider null

        If T1 node is null,
            consider T2 node

        If T2 node is null,
            consider T1 node

        If T1 node is not null and T2 node is not null,
            consider Sum of both

*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MergeTwoBinaryTrees_LC_617 {

    public TreeNode mergeTreesRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;

        if (root2 == null)
            return root1;

        root1.val = root1.val + root2.val;

        root1.left = mergeTreesRecursive(root1.left, root2.left);
        root1.right = mergeTreesRecursive(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTreesDFS(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;

        if (root2 == null)
            return root1;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {root1, root2});              //In stack we will always push when both T1 and T2 node are there or not null

        while (!stack.isEmpty()) {
            TreeNode[] curr = stack.pop();                      //here curr[0] will be T1 and curr[1] will be T2

            curr[0].val = curr[0].val + curr[1].val;

            //Left tree
            if (curr[0].left == null) {
                curr[0].left = curr[1].left;
            }
            else if (curr[1].left != null) {           //left is not null because above if condition was false and right is also not null, so push in stack. We push in stack when both left and right are not null
                stack.push(new TreeNode[] {curr[0].left, curr[1].left});
            }

            //Do same thing right node
            if (curr[0].right == null) {
                curr[0].right = curr[1].right;
            }
            else if (curr[1].right != null) {
                stack.push(new TreeNode[] {curr[0].right, curr[1].right});
            }

        }

        return root1;
    }

    public TreeNode mergeTreesBFS(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;

        if (root2 == null)
            return root1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] {root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] curr = queue.remove();

            curr[0].val = curr[0].val + curr[1].val;

            //Left tree
            if (curr[0].left == null) {
                curr[0].left = curr[1].left;
            }
            else if (curr[1].left != null) {
                queue.add(new TreeNode[] {curr[0].left, curr[1].left});
            }

            //Do same thing right node
            if (curr[0].right == null) {
                curr[0].right = curr[1].right;
            }
            else if (curr[1].right != null) {
                queue.add(new TreeNode[] {curr[0].right, curr[1].right});
            }

        }

        return root1;
    }
}


















