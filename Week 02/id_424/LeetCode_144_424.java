package com.wangyao.Binary_Tree_Preorder_Traversal;

import com.wangyao.Lowest_Common_Ancestor_of_a_Binary_Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ori
 * @Time: 2019/10/27
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) return result;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.poll();

            result.add(head.val);
            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);
        }

        return result;
    }
}
