/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class LeetCode_33_009 {
    public static void main(String[] args) {
        LeetCode_33_009 test = new LeetCode_33_009();
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(test.search(nums, target));
    }

    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {    //target在左边部分
                    right = mid - 1;
                } else {                    //target在右边部分
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {    //target在右边部分
                    left = mid + 1;
                } else {        //target在左边部分
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
