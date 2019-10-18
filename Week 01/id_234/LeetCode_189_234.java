public class Main {
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
  //
}
