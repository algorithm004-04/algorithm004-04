/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * LeetCode_590_034
 *
 * @Author mengdebiao@duxiaoman.com
 * @Date 2019/10/27 9:40 AM
 **/
public class LeetCode_590_034 {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(Node node, List<Integer> list) {
         if (node == null) {
             return;
         }
         for (Node child : node.children) {
             postorder(child, list);
         }
         list.add(node.val);
    }

    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);

            for (Node child : node.children) {
                stack.push(child);
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
