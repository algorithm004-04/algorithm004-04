/**
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int startIndex = 0,
                endIndex = nums.length - 1,
                midIndex;

        while(startIndex <= endIndex) {
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[startIndex] <= nums[midIndex]) {
                if (target >= nums[startIndex] && target < nums[midIndex]) {
                    endIndex = endIndex - 1;
                } else {
                    startIndex = startIndex + 1;
                }
            } else {
                if (target > nums[midIndex] && target <= nums[endIndex]) {
                    startIndex = startIndex + 1;
                } else {
                    endIndex = endIndex - 1;
                }
            }
        }

        return -1;
    }
}



