/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> result = new ArrayList<>();
       helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], result, n);
       return result;
    }

    private void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, String[] temp, List<List<String>> result, int n) {
        if (row == n) {
            result.add(Arrays.asList(temp.clone()));
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n;
            int id2 = 2 * n - row - col - 1;
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;

                char[] c = new char[n];
                Arrays.fill(c, '.');
                c[col] = 'Q';
                temp[row] = String.valueOf(c);

                helper(row + 1, cols, d1, d2, temp, result, n);

                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}

