/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 当[0,mid]有序时,向后规约条件
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
                // 当[0,mid]发生旋转时，向后规约条件
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
        // if (nums == null || nums.length == 0) {
        // return -1;
        // }
        // int start = 0;
        // int end = nums.length - 1;
        // int mid;
        // while (start <= end) {
        // mid = start + (end - start) / 2;
        // if (nums[mid] == target) {
        // return mid;
        // }
        // // 前半部分有序,注意此处用小于等于
        // if (nums[start] <= nums[mid]) {
        // // target在前半部分
        // if (target >= nums[start] && target < nums[mid]) {
        // end = mid - 1;
        // } else {
        // start = mid + 1;
        // }
        // } else {
        // if (target <= nums[end] && target > nums[mid]) {
        // start = mid + 1;
        // } else {
        // end = mid - 1;
        // }
        // }

        // }
        // return -1;

    }
}
// @lc code=end
