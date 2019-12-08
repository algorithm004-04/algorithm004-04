package com.codertoy.week03;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leecode_102_339 {
    // BFS 需要记录level，每次while循环之前先记录该层元素数量
    // 然后通过for循环遍历整层元素，每个元素会被访问一次，时间复杂度为O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 0;
        while (!deque.isEmpty()) {
            res.add(new ArrayList<>());

            int levelLength = deque.size();
            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = deque.pollFirst();
                res.get(level).add(node.val);

                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            level++;
        }
        return res;
    }

    // 递归法，递归法的速度要快于队列法，时间复杂度为O(n)
    public List<List<Integer>> levelOrder_Recursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        _recursionHelp(res, root, 0);
        return res;
    }

    private void _recursionHelp(List<List<Integer>> res, TreeNode node, int level) {
        // terminator
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        // process current level
        res.get(level).add(node.val);

        // drill down
        if (node.left != null) _recursionHelp(res, node.left, level + 1);
        if (node.right != null) _recursionHelp(res, node.right, level + 1);
    }
}
