package com.codertoy.week02;

import java.util.ArrayList;
import java.util.List;

public class Leecode_589_339 {
    // 递归方法，时间复杂度为O(n)
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        for (Node node : root.children) {
            list.addAll(preorder(node));
        }
        return list;
    }
}
