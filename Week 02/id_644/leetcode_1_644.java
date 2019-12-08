package com.company;
/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosum {
    public static void main(String[] args) {
        int[] test = {2,7,8,9,5,6};
        int target = 11;
        int[] res = twoSum(test,target);
        System.out.println(Arrays.toString(res));

    }
    //暴力法 O(n*n)
    public static int[] twoSum_force(int[] nums, int target) {
        if (nums.length < 2) return null;
        for(int i = 0;i < nums.length;i++) {
            for(int j = i+1;j<nums.length;j++) {
                if(nums[i] + nums[j]  == target)
                    return new int[] {i,j};
            }
        }
        return null;
    }

    //指针 O(n*n)
    public static int[] twoSum_point(int[] nums, int target) {
        int lp;
        for(int i=0;i < nums.length;i++) {
            lp = i+1;
            int sec_tar = target - nums[i];
            while(lp >i && lp < nums.length){
                if(nums[lp] == sec_tar)
                    return new int[] {i,lp};
                lp++;
            }
        }
        return null;
    }

    //hashmap O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> nums_map = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length;i++) {
            int res = target - nums[i];
            if(nums_map.containsKey(res)) {
                return new int[] {nums_map.get(res),i};
            }
            nums_map.put(nums[i],i);
        }
        return null;
    }

}
