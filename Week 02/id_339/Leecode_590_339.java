package com.codertoy.week02;

import java.util.*;

public class Leecode_590_339 {
    // 递归方法，时间复杂度为O(n)
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        for (int i = 0; i < root.children.size(); i++) {
            list.addAll(postorder(root.children.get(i)));
        }
        list.add(root.val);
        return list;
    }

}
