package com.company;

import java.util.ArrayList;
import java.util.List;

public class postorder {

    public static void main(String[] args) {

    }
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }
    //递归
    public void helper(Node root) {
        if(root == null) {
            return;
        }
        /*for(Node child: root.children) {
            helper(child);  两层方法调用 iterater 和 递归结合效率相对低
        }\
        */
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
        res.add(root.val);
    }
    //模拟 stack
	public void helper(Node root) {
        if ( root == null ) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node  cur = root;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            for(Node n1 : cur.children) {
                stack.push(n1);
            }
        }
        Collections.reverse(res);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
