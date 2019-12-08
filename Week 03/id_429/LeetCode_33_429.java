package id_429;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 来源：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * @author liqiuying
 * @date 2019-11-03
 */
public class LeetCode_33_429 {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            //在mid左侧
            if ((nums[left] <= nums[mid] && target <= nums[mid] && target >= nums[left]) ||
                    (nums[left] > nums[mid] && target <= nums[mid]) ||
                    (nums[left] > nums[mid] && target >= nums[mid] && target >= nums[left])) {
                right = mid - 1;
            } else {
                //在mid右侧
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(search(nums, 6));
    }
}