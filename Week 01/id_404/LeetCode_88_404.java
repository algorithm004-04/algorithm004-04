/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;

        while (m >= 0 && n >= 0) {
            nums1[p] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
// @lc code=end
