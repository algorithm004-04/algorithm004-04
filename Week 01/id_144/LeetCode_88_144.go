/*
 * @lc app=leetcode id=88 lang=golang
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (36.80%)
 * Likes:    1347
 * Dislikes: 3154
 * Total Accepted:    431.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */

// @lc code=start
// v1, 将 nums2 追加在 nums1 后面，对得到的数组排序，时间复杂度 O((m+n)log(m+n))，缺点是：并没有充分利用两个已知数组的“已排序”的特性
import "sort"
func merge(nums1 []int, m int, nums2 []int, n int) {
	nums1 = append(nums1[:m], nums2...)
	sort.Ints(nums1)
}

// v2, 从后往前数组遍历，时间复杂度为 O(n)
func merge(nums1 []int, m int, nums2 []int, n int) {
	i := m - 1
	j := n - 1
	k := m + n - 1
	for i >= 0 && j >= 0 {
		if nums1[i] > nums2[j] {
			nums1[k] = nums1[i]
			k--
			i--
		} else {
			nums1[k] = nums2[j]
			k--
			j--
		}
	}
	for j >= 0 {	// 如果 nums2 有剩余，需要继续向前填充
		nums1[k] = nums2[j]
		k--
		j--
	}
}

// @lc code=end

