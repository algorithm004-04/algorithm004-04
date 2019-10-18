public class Solution {
  // 暴力 T:O(k*n) S:O(1)
  public static void rotate1(int[] nums, int k) {

    k = k % nums.length;

    for (int i = 0; i < k; i++) {
      int last = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        int temp = nums[j];
        nums[j] = last;
        last = temp;
      }
    }
  }
  //双数组 T:O(n) S:O(n)
  public void rotate(int[] nums, int k) {
      k = k % nums.length;
      int[] copy_nums = new int[nums.length];
      for (int i = 0; i<nums.length;i++){
          copy_nums[(i+k)%nums.length]=nums[i];
      }
      for (int j = 0;j<nums.length;j++){
          nums[j]=copy_nums[j];
      }
  }
}
