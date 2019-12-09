package com.kkkkkk.demovvorld.leetcode189;

import com.alibaba.fastjson.JSON;

public class Solution {
    public void rotate(int[] nums, int k) {
        threeReverse(nums, k);
    }

    /**
     * 1. 暴力解法（优化版）
     */
    public void justDoIt(int[] nums, int k) {
        if (nums.length <= 1 || k % nums.length == 0) {
            return;
        }
        for (int i = 0; i < k % nums.length; ++i) {
            int last = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = last;
        }
    }

    /**
     * 2. 三次翻转
     */
    public void threeReverse(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{1, 2, 3, 4, 5};
        new Solution().rotate(t, 6);
        System.out.println(JSON.toJSONString(t));
    }
}
