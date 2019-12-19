package com.kkkkkk.demovvorld.leetcode62;

public class Solution2 {
    public int uniquePaths(int m, int n) {
        // dp optimal
        int[][] opt = new int[m][n];
        for (int i = 0; i < n; ++i) opt[0][i] = 1;
        for (int j = 0; j < m; ++j) opt[j][0] = 1;
        for (int p = 1; p < m; ++p) {
            for (int q = 1; q < n; ++q) {
                opt[p][q] = opt[p - 1][q] + opt[p][q - 1];
            }
        }
        return opt[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(3, 2));
    }
}
