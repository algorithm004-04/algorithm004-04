package com.codertoy.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leecode_94_339 {

    // 时间复杂度为O(n^2)，因为每个node被访问两次，第一次是在遍历的时候，第二次是在stack弹出的时候
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
