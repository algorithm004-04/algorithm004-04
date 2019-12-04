/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.50%)
 * Likes:    329
 * Dislikes: 0
 * Total Accepted:    77.1K
 * Total Submissions: 169.3K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // 指向nums1的最后一个
        int p2 = n - 1; // 指向nums2的最后一个
        for (int i = nums1.length - 1; i >= 0; i--) {
            // num1值用完了
            if (-1 == p1) {
                nums1[i] = nums2[p2--];
                continue;
            }
            // num2值用完了
            if (-1 == p2) {
                nums1[i] = nums1[p1--];
                continue;
            }

            // 谁大谁先
            if (nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
    }
}
// @lc code=end
