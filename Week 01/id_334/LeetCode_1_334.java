package Array;

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

// 第一个想法：利用hashMap的key不会重复原则即可，时间复杂度O(n)

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_1_334 {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 3, 11, 15, 2};
        int[] result = twoSumV1(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Runtime: 2 ms, faster than 98.89% of Java online submissions for Two Sum.
     * Memory Usage: 37.7 MB, less than 98.56% of Java online submissions for Two Sum.
     */
    public static int[] twoSumV1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer dif = hashMap.get(target - nums[i]);
            if (dif != null) {
                return new int[]{dif, i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


