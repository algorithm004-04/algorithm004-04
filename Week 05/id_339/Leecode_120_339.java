package com.codertoy.week05;

import java.util.List;

public class Leecode_120_339 {
    // DP: f[i,j]=min(f[i+1, j], f[i+1, j+1]) + a[i,i];
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    int row = 0;
    Integer[][] memo;

    // recuries
    public int minimumTotal1(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return _help(0, 0, triangle);
    }

    private int _help(int level, int curr, List<List<Integer>> triangle) {
        if (memo[level][curr] != null) return memo[level][curr];
        if (level == row - 1) return memo[level][curr] = triangle.get(level).get(curr);

        int left = _help(level + 1, curr, triangle);
        int right = _help(level + 1, curr + 1, triangle);
        return memo[level][curr] = Math.min(left, right) + triangle.get(level).get(curr);
    }
}
