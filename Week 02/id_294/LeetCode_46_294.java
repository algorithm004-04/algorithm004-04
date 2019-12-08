package week02;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_46_294 {


    /**
     * 全排列
     * 解法1:
     * 1.打印当前数组
     * 2.分别交换第0个元素与1~len-1的元素
     * 3.缩小1个元素的问题规模，数组缩小为2~len-1，回到第1步
     * 思考：如何证明通过这种交换方式一定能得到所有的情况？
     * @param nums
     * @return
     */
    public void helper(int[] nums, int  first, List<List<Integer>> result, boolean add) {
        if (first >= nums.length) {
            return;
        }
        if (add) {
            List<Integer> record = new ArrayList<>();
            for (int i = 0 ; i < nums.length; i++) {
                record.add(nums[i]);
            }
            result.add(record);
        }
        for (int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            helper(nums, first + 1, result, first != i); // first == i说明不交换，没有发生变化，但子问题还要处理，所以还要继续递归
            swap(nums, first, i);
        }
    }

    /**
     * 解法二
     * 穷举+剪枝
     * 每层递归处理一位，每一位用循环查找位置
     * 通过记录已经使用的元素，进行剪枝
     * @param nums
     * @param level
     * @param result
     */
    public void helper2(int[] nums, int level, List<Integer> record, Map<Integer, Integer> visited, List<List<Integer>> result) {
        if (level >= nums.length) {
            result.add(new ArrayList<>(record));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.containsKey(Integer.valueOf(i))) {
                record.add(nums[i]);
                visited.put(i, 1);
                helper2(nums, level + 1, record, visited, result);
                record.remove(record.size()-1);
                visited.remove(Integer.valueOf(i));
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        helper(nums,  0, result, true);
        helper2(nums, 0, new ArrayList<>(), new HashMap<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> r = new LeetCode_46_294().permute(nums);
        System.out.println(r);
    }
}
