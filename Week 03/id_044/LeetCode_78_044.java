package week_02.lesson8;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        //迭代法
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums) {
            return result;
        }
        /*List<Integer> subResult = new ArrayList<>();
        result.add(subResult);
        for (int n : nums) {
            int count = result.size();
            for (int i = 0; i < count; i++) {
                subResult = new ArrayList<>(result.get(i));
                subResult.add(n);
                result.add(subResult);
            }
        }*/

        //递归(回溯法)
        backTrack(0, nums, result, new ArrayList<>());
        return result;

    }

    public static void backTrack(int i, int[] nums, List<List<Integer>> result, ArrayList<Integer> tmp) {

        result.add(new ArrayList<>(tmp));

        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backTrack(j + 1, nums, result, tmp);
            //因为要回到上一层去，当前层的结果要移除
            tmp.remove(tmp.size() - 1);
        }


    }


    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}
