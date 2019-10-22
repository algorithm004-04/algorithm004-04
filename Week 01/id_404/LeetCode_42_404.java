/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int res = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        max_left[0] = height[0];
        max_right[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(height[i], max_left[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            max_right[i] = Math.max(height[i], max_right[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(max_left[i], max_right[i]) - height[i];
        }

        return res;
    }
}
// @lc code=end
