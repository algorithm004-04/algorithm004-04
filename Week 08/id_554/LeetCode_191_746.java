package com.kkkkkk.demovvorld.leetcode746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int opt1 = 0, opt2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int opt = cost[i] + Math.min(opt1, opt2);
            opt2 = opt;
            opt1 = opt2;
        }
        return Math.min(opt1, opt2);
    }
}
