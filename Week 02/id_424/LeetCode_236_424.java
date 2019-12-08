package com.wangyao.Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Ori
 * @Time: 2019/10/26
 */
public class Solution {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasChildNode(root, p, q);
        return this.result;
    }

    public boolean hasChildNode(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null)
            return false;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        int left = hasChildNode(currentNode.left, p, q) ? 1 : 0;
        int right = hasChildNode(currentNode.right, p, q) ? 1 : 0;

        if (mid + left + right >= 2)
            this.result = currentNode;

        return mid + left + right > 0;
    }
}
