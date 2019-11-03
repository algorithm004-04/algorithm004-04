class Solution {
  // 后向前双指针 T:O(m+n) S:O(1)
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int last = m + n - 1;
    int nums1_last = m - 1;
    int nums2_last = n - 1;
    while (nums1_last >= 0 && nums2_last >= 0) {
      if (nums1[nums1_last] < nums2[nums2_last]) {
        nums1[last] = nums2[nums2_last];
        nums2_last = nums2_last - 1;
      } else {
        nums1[last] = nums1[nums1_last];
        nums1_last = nums1_last - 1;
      }
      last = last - 1;
    }
    System.arraycopy(nums2, 0, nums1, 0, nums2_last + 1);
  }
}
