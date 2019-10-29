package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorder {
    List<Integer> res = new ArrayList<Integer>();
    public static void main(String[] args) {

    }
    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }
    // recur
    public void helper_recur(Node root) {
        if(root == null) {
            return;
        }
        /*for(Node child: root.children) {
            helper(child);  两层方法调用 iterater 和 递归结合效率相对低
        }\
        */
        res.add(root.val);
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }

    }
    public void helper(Node root) {
        Stack<Node> stack = new Stack<>();
        if(root ==null)
            return;
        stack.push(root);
        Node cur  =root;
        while(!stack.isEmpty() ) {
            cur = stack.pop();
            res.add(cur.val);
            int s = cur.children.size();
            for(int i = s-1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
    }

    /**
     * public List<Integer> helper(Node root, List<Integer> res) {
     *         Stack<Node> stack = new Stack<>();
     *         if(root ==null)
     *             return res;
     *         stack.push(root);
     *         Node cur  =root;
     *         while(stack.isEmpty() ) {
     *             cur = stack.pop();
     *             res.add(cur.val);
     *             int s = cur.children.size();
     *             for(int i = s-1; i >= 0; i--) {
     *                 stack.push(cur.children.get(i));
     *             }
     *         }
     *        return res;
     *     }
     * }
     */


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
