/*
 * @lc app=leetcode id=88 lang=golang
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
func merge(nums1 []int, m int, nums2 []int, n int)  {
	//1.loop from end to begin
	//2.add missing elements from nums2
	k := m + n - 1
	i, j := m-1, n-1
	for i >= 0 && j >=0 {
		if nums1[i] > nums2[j] {
			nums1[k] = nums1[i]
			i--
		} else {
			nums1[k] = nums2[j]
			j--
		}
		k--
	}

	copy(nums1[:j+1], nums2[:j+1])
}
// @lc code=end

