package com.zenglinhui.leetcode;

import java.util.ArrayList;
import java.util.List;


public class NAryTreePreorder {

    static List<Integer> result = new ArrayList<>();

    public static List<Integer> preorder(Node root) {

        if (null == root) {
            return new ArrayList<>(0);
        }

        result.add(root.val);

        if (null != root.children) {
            for (Node node :
                    root.children) {
                preorder(node);
            }
        }

        return result;

    }

    public static void main(String[] args) {

        List<Node> firstChildren = new ArrayList<>(3);
        List<Node> secondChildren = new ArrayList<>(2);
        secondChildren.add(new Node(5,null));
        secondChildren.add(new Node(6,null));
        firstChildren.add(new Node(3,secondChildren));
        firstChildren.add(new Node(2,null));
        firstChildren.add(new Node(4,null));

        Node node = new Node(1,firstChildren);
        List<Integer> res = preorder(node);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
