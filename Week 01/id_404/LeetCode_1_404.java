/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two sum
 */

/*
思路：
1. 暴力破解
2. 利用字典
 */
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end
