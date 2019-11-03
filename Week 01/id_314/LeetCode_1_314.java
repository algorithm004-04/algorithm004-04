//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
// Example:
//
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
//
// Related Topics Array Hash Table

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: wangchuande
 * @Date: 2019/10/20 19:53
 */
public class LeetCode_1_314 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;

            if (map.containsKey(second) && map.get(second) != i) {
                return new int[]{i, map.get(second)};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LeetCode_1_314 leetCode1314 = new LeetCode_1_314();
        int[] testData = new int[]{3,2,4};
        int[] expected = new int[]{1,2};

        int[] result = leetCode1314.twoSum(testData, 6);

        System.out.println("Is Pass: " + Arrays.equals(result, expected));
    }

}

