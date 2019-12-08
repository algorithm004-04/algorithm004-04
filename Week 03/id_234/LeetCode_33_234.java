package week_03;

public class LeetCode_33_234 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      // 左边有序  判断是否向右查找
      // 注意这里  ↓↓↓  边界条件
      if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
        left = mid + 1;
      } else if (target > nums[mid] && target < nums[0]) { // 左边无序 判断是否向右查找  左边无序则右边一定有序
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left == right && nums[left] == target ? left : -1;
  }
}
