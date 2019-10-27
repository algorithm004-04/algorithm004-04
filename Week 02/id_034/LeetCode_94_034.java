/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  二叉树的中序遍历
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/10/26 11:33 PM
 **/
public class LeetCode_94_034 {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    private static class TreeNode {

        public int val;

        public TreeNode left;

        public TreeNode right;
    }

}
