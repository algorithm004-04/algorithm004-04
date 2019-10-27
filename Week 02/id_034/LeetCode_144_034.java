/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  二叉树的前序遍历
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/10/27 9:18 AM
 **/
public class LeetCode_144_034 {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node ==  null) {
            return;
        }

        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }

    private List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    private static class TreeNode {

        public int val;

        public TreeNode left;

        public TreeNode right;
    }
}
