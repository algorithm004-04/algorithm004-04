package week01;

public class LeetCode_88_294 {
    /**
     * 从后向前比较
     * 如果从前向后比较，那么插入后，会有元素的挪动，会导致O(n^2)的时间复杂度
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index] = nums2[index2];
                index2 --;
            } else {
                nums1[index] = nums1[index1];
                index1 --;
            }
            index --;
        }
        if (index1 >= 0) {
            for (int i = index1; i >= 0; i--) {
                nums1[index] = nums1[i];
                index --;
            }
        }

        if (index2 >= 0) {
            for (int i = index2; i >= 0; i--) {
                nums1[index] = nums2[i];
                index --;
            }
        }
    }
}
