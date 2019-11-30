package com.codertoy.week05;

import java.util.Arrays;

public class Leecode_53_339 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i=1;i<nums.length; i++) {
            nums[i] = Math.max(nums[i-1], 0) + nums[i];
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
