package com.kkkkkk.demovvorld.leetcode72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] opt = new int[m + 1][n + 1];
        for (int i = 0; i < n; ++i) {
            opt[0][i] = i;
        }
        for (int j = 0; j < m; ++j) {
            opt[j][0] = j;
        }
        for (int p = 1; p < m; ++p) {
            for (int q = 1; q < n; ++q) {
                if (word1.charAt(p) == word2.charAt(q)) {
                    opt[p][q] = opt[p - 1][q - 1];
                } else {
                    opt[p][q] = Math.min(Math.min(opt[p - 1][q - 1], opt[p - 1][q]), opt[p][q - 1]) + 1;
                }
            }
        }
        return opt[m][n];
    }
}
