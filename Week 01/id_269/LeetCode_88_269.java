/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

1. 两个数组合并后的总长度为m+n
2. 定义一个指针为 int k = m + n - 1;代表着合并后数组最后的元素。
3. 然后依次比较 数组1和数组2最后一个数字的大小，哪个大就设置到 k位置上。然后k-- m或者n也自减
4. 边界条件是数组2中n指针小于零时，说明合并完毕。数组1中m小于0时，直接将数组2合并到数组1的指定位置上即可
*
 */
public class LeetCode_88_269 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //合并后数组总长度为m+n
        int k = m + n - 1;

        //n是数组2的总长度，如果数组2遍历完了就说明结束了
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[k] = nums1[m - 1];
                m--;
            } else {
                nums1[k] = nums2[n - 1];
                n--;
            }
            k--;
        }
    }
}
