package com.zenglinhui.leetcode.lessons3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {

    static List<List<Integer>> levels = new ArrayList<>();

    public static void helper(TreeNode node,int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if (null != node.left) {
            helper(node.left,level + 1);
        }
        if (null != node.right) {
            helper(node.right,level + 1);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return levels;
        }
        helper(root,0);
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode secondRight = new TreeNode(20);
        root.right = secondRight;
        secondRight.left = new TreeNode(15);
        secondRight.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
