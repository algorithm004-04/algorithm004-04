package SuanFa;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 *
 * 	初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_88_574 {
    public static void main(String[] args) {
        int []nums1 = {4,0,0,0,0,0};
        int m = 1;
        int []nums2 = {1,2,3,5,6};
        int n = 5;
        merge2(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = nums1.clone();
        int indexI = temp.length-n-1;
        int indexJ = n-1;
        int indexK = nums1.length-1;
        while((indexI >= 0 || indexJ >= 0) && indexK >= 0) {
            if (indexI >= 0 && indexJ >= 0) {
                nums1[indexK--] = temp[indexI] < nums2[indexJ] ? nums2[indexJ--] : temp[indexI--];
            }
            else if (indexI >= 0 && indexJ < 0) {
                nums1[indexK--] = temp[indexI--];
            }
            else {
                nums1[indexK--] = nums2[indexJ--];
            }
        }
    }
}
