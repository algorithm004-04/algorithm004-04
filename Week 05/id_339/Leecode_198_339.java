package com.codertoy.week05;

public class Leecode_198_339 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[][] items = new int[len][2];
        items[0][0] = 0;
        items[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            items[i][0] = Math.max(items[i - 1][0], items[i - 1][1]);
            items[i][1] = items[i - 1][0] + nums[i];
        }
        return Math.max(items[len - 1][0], items[len - 1][1]);
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] items = new int[nums.length];
        items[0] = nums[0];
        items[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(items[0], items[1]);
        for (int i = 2; i < nums.length; i++) {
            items[i] = Math.max(items[i - 1], items[i - 2] + nums[i]);
            res = Math.max(res, items[i]);
        }
        return res;
    }
}
