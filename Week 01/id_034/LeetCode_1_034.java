
package com.playok.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 *
 * @Author blackberry
 * @Date 2019/10/20 12:07 PM
 **/
public class TwoSum {

    /**
     * 暴力法 双重循环
     * 时间复杂度O(n) 空间负责O(1)
     * 耗时40ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if (len <= 1) {
            return new int[0];
        }

        for (int i = 0; i < len - 1; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表 一层循环
     * 时间复杂度O(n) 空间复杂度O(n)
     * 以空间换时间
     * 耗时3ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        if (len <= 1) {
            return new int[0];
        }
        Map<Integer, Integer> mem = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            if (mem.containsKey(target - nums[i])) {
                return new int[]{i, mem.get(target - nums[i])};
            }
            mem.put(nums[i], i);
        }
        return new int[0];
    }

}
