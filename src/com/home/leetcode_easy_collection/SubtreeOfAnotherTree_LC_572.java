package com.home.leetcode_easy_collection;

/*

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
        Input: root = [3,4,5,1,2], subRoot = [4,1,2]
        Output: true

Example 2:
        Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
        Output: false

*/

public class SubtreeOfAnotherTree_LC_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String t1Str = preOrderTraversal(root);
        String t2Str = preOrderTraversal(subRoot);

        return t1Str.contains(t2Str);
    }

    private String preOrderTraversal(TreeNode node) {
        if (node == null)
            return "null";          //append null String

        StringBuilder sb = new StringBuilder("^");      //need to add a separator for special cases, check below.

        sb.append(node.val);
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
    }

}

/*

We can use Pre-Order, In-Order or Post-Order traversal technique.
Get the data string using any above traversal technique for both trees.
Then compare or check if T2 data string is part of T1 data string.

Level-Order traversal will not give us the correct output, the data string will be formed differently, it will not check how the nodes are connected, it will just go level by level. You can check.

We will have to include null nodes as well, otherwise following trees will return true

         4							 4
        /							/ \
       1						   1   2
      /
     2

    With nulls - 4, 1, 2, null, null, null, null						4, 1, null, null, 2 null, null,
    Without nulls - 4, 1, 2												4, 1, 2


Time - O(N)	- N is total nos of nodes in bigger tree.
Space - O(N) - because we are using recursion, and we are using space or recursion stack to iterate over all nodes in a tree

You have to add string("^") to your initial string otherwise it breaks at special cases like
        T1 = 12nullnull
        T2 = 2nullnull

*/
