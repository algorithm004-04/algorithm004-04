package com.kkkkkk.demovvorld.leetcode433;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        // 前置条件校验
        if (start.equals(end)) {
            return -1;
        }

        // 通用BFS模板
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int treeLevel = 1;

        // 基因库
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        // 原始基因
        char[] base = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            String curr = queue.remove();
            char[] currChars = curr.toCharArray();
            // 树 - 同一层
            for (int i = 0; i < currChars.length; ++i) {
                char old = currChars[i];
                for (int j = 0; j < base.length; ++j) {
                    currChars[i] = base[j];
                    String newFresh = new String(currChars);
                    if (end.equals(newFresh)) {
                        return treeLevel;
                    }
                    if (bankSet.contains(newFresh) && !visited.contains(newFresh)) {
                        visited.add(newFresh);
                        queue.add(newFresh);
                    }
                }
                currChars[i] = old;
            }
            ++treeLevel;
        }

        return -1;
    }
}
