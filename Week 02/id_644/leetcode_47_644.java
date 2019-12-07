package com.company;
/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute2 {
    public static void main(String[] args) {
        int[] test = {1,1,2};
        System.out.println(permuteUnique(test));

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length ==0) return  res;
        boolean[] used = new boolean[nums.length];
        List<Integer> temp =  new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,used,res,temp);
        return res;
    }
        // 回溯 剪纸还是不太明白
    public static void helper(int[] nums,boolean[] used,List<List<Integer>> res,List<Integer> temp) {
        //System.out.println("jump in");
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            System.out.println(new ArrayList<>(temp));
            return;
        }
        for(int i= 0; i<nums.length;i++) {
          //  System.out.println(Arrays.toString(used));
           // System.out.println("nums val and index "+temp+"  "+i);
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            temp.add(nums[i]);
            helper(nums,used,res,temp);
            used[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}
