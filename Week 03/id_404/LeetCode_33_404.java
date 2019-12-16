/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 旋转的数组至少有一半的数字是有序的
            // 左半段是有序的
            if (nums[low] <= nums[mid]) {
                // 如果目标大于最左值并且目标小鱼中间值，右坐标左移，否则左坐标右移动
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            // 右半段是有序的
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end
