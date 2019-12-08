package org.liqi.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_749 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postorder(root, res);
        return res;
    }

    private void postorder(Node node, List<Integer> res) {
        for (Node c : node.children) {
            postorder(c, res);
        }
        res.add(node.val);
    }

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
