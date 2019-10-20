/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int lastZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (lastZeroIndex != i) {
                    nums[lastZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                lastZeroIndex++;
            }
        }
    }
}
// @lc code=end

