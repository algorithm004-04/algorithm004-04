package com.codertoy.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leecode_144_339 {
    // 栈维护节点方法，改方法的时间复杂度为O(n)，每个节点被访问一次
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> rightStack = new Stack<>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                rightStack.push(root.right);
            }
            root = root.left;
            if (root == null && !rightStack.isEmpty()) {
                root = rightStack.pop();
            }
        }
        return list;
    }

    // 递归方法，时间复杂度为O(n)，每个节点被访问一次，相较于自己维护栈的方法更为简单
    public List<Integer> preorderTraversal_Recursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(preorderTraversal_Recursive(root.left));
        list.addAll(preorderTraversal_Recursive(root.right));
        return list;
    }
}
