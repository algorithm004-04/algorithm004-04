package com.codertoy.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode_429_339 {
    // 栈维护Chirldren节点法，时间复杂度为O(n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rootList = new ArrayList<>();
        if (root == null) return rootList;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevelList = new ArrayList<>();
            // len保存当前队列中的Node数
            int len = queue.size();
            for (int i = 0; i < len; ++i) {
                Node cur = queue.poll();
                curLevelList.add(cur.val);
                for (Node node : cur.children) {
                    queue.offer(node);
                }
            }
            rootList.add(curLevelList);
        }
        return rootList;
    }
}
