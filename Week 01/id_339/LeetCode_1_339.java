package com.codertoy.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // 暴力法
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    // 哈希法
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int searchInt = target - nums[i];
            if (tempMap.containsKey(searchInt)) {
                result[0] = i;
                result[1] = tempMap.get(searchInt);
                break;
            } else {
                tempMap.put(nums[i], i);
            }
        }
        return result;
    }
}
