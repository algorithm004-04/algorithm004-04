class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m -= 1;
        n -= 1;
        while (m > -1 && n > -1) {
            nums1[k--] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }

}