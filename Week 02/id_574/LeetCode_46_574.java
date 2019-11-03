package SuanFa.Week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_46_574 {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(permute1(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        boolean []used = new boolean[nums.length];
        generatePermute(nums, used, 0, new Stack<>(), list);
        return list;
    }

    private static void generatePermute(int[] nums, boolean[] used, int curSize, Stack<Integer> path, List<List<Integer>> list) {
        if (curSize == nums.length) {
            list.add(new ArrayList<>(path));
        }
        for (int i=0; i< nums.length;i++) {
            if (!used[i]) {
                path.push(nums[i]);
                used[i] = true;
                generatePermute(nums,used,curSize+1,path,list);
                path.pop();
                used[i] = false;
            }
        }
    }

    /**
     * 交换数组
     */
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        helper(nums,0,list);
        return list;
    }

    private static void helper(int[] nums, int begin, List<List<Integer>> list) {
        if (begin == nums.length) {
            List<Integer> currRes = new ArrayList<>();
            for (int i=0;i<nums.length;i++) {
                currRes.add(nums[i]);
            }
            list.add(currRes);
        }
        for (int i=begin;i<nums.length;i++) {
            swap(nums,begin,i);
            helper(nums,begin+1,list);
            swap(nums,i,begin);
        }
    }

    private static void swap(int[] nums, int i, int begin) {
        int temp = nums[i];
        nums[i] = nums[begin];
        nums[begin] = temp;
    }
}
