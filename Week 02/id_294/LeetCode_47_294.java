package week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_47_294 {

    /**
     * 回溯法
     * 每层递归处理一位，每一位用循环查找位置
     * 通过记录已经使用的元素，进行剪枝
     * @param nums
     * @param level
     * @param result
     */
    public void helper1(int[] nums, int level, List<Integer> record, Map<Integer, Integer> visited, List<List<Integer>> result) {
        if (level >= nums.length) {
            result.add(new ArrayList<>(record));
            return;
        }
        //记录当前层已经使用过的元素，如果已经使用过了，就pass
        Map<Integer, Integer> used = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //一个元素必须满足在当前层没有使用过，同时当前没有被其他递归层使用
            if (!visited.containsKey(i) && !used.containsKey(nums[i])) {
                record.add(nums[i]);
                used.put(nums[i], 1);
                visited.put(i, 1);
                helper1(nums, level + 1, record, visited, result);
                record.remove(record.size()-1);
                visited.remove(i);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper1(nums, 0, new ArrayList<>(), new HashMap<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> r = new LeetCode_47_294().permute(nums);
        System.out.println(r);
    }
}
