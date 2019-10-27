/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * LeetCode_589_034
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/10/27 10:04 AM
 **/
public class LeetCode_589_034 {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node child : node.children) {
            preorder(child, list);
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            for (int i = node.children.size() - 1; i >= 0 ; i --) {
                stack.push(node.children.get(i));
            }
        }

        return list;
    }



    public static class Node {

        public int val;

        public List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
