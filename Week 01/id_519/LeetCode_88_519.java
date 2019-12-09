package algorithm.chapter1;

import java.util.Arrays;

/**
 *【合并两个有序数组】 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 说明: 初始化 nums1
 * 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例: 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3 输出: [1,2,2,3,5,6]
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 
 * @author chying
 *
 */
public class LeetCode_88_519 {

	/**
	 * 双指针，从后往前插入
	 * 
	 */
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}

		return nums1;
	}

	public static void main(String[] args) {
		LeetCode_88_519 a = new LeetCode_88_519();
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		System.out.println(Arrays.toString(a.merge(nums1, 3, nums2, 3)));
	}
}
