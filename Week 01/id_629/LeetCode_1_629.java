package com.zhk.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//leetcode 1 twosum
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j),i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
