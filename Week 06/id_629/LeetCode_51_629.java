package com.zhk.Search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode 51
public class NQueues {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        List<String> list = new ArrayList<>();
        recursiveHelper(res, list, pie, na, col, n, 0);

        return res;
    }

    private void recursiveHelper(List<List<String>> res, List<String> list, Set<Integer> pie,
                                 Set<Integer> na, Set<Integer> col, int n, int row) {
        if (row == n) {
            List l = new ArrayList(list);
            res.add(l);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!pie.contains(row + i) && !na.contains(i - row) && !col.contains(i)) {

                pie.add(row + i);
                na.add(i - row);
                col.add(i);
                //  char[] crow = new char[n];
//        Arrays.fill(crow, '.');
//        crow[i] = 'Q';
//        list.add(crow.toString());
                String temp = getStr(n, i);
                list.add(temp);
                recursiveHelper(res, list, pie, na, col, n, row + 1);
                pie.remove(row + i);
                na.remove(i - row);
                col.remove(i);
                list.remove(temp);
            }
        }
        return;
    }

    private String getStr(int n, int j) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) {
                stringBuilder.append("Q");
            } else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }
}
