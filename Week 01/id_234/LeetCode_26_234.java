public class Solution {
  // 双指针 T:O(n) S:O(1)
  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = i + 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i = i + 1;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
