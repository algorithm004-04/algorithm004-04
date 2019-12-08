class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if( target < nums[0] && target > nums[mid]) {
        left = mid + 1;
      } else if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }
    return left == right && nums[left] == target ? left : -1;

  }
}