/*
 * @lc app=leetcode.cn id=88 lang=golang
 *
 * [88] 合并两个有序数组
 * 暂存nums1数据，双指针同时遍历两个数组，按大小顺序存入nums1
 * 看了解析里面的从后往前遍历，思想更巧妙些，很遗憾没想到
 */

// @lc code=start
func merge(nums1 []int, m int, nums2 []int, n int) {
	tmp := make([]int, m)
	for i := 0; i < m; i++ {
		tmp[i] = nums1[i]
	}
	p0 := 0
	p1 := 0
	p2 := 0

	for p1 < m && p2 < n {
		if tmp[p1] < nums2[p2] {
			nums1[p0] = tmp[p1]
			p1++
		} else {
			nums1[p0] = nums2[p2]
			p2++
		}
		p0++
	}
	
	if p1 < m {
		for ; p1 < m; p1++ {
			nums1[p0] = tmp[p1]
			p0++
		}
	}
	if p2 < n {
		for ; p2 < n; p2++ {
			nums1[p0] = nums2[p2]
			p0++
		}
	}
}

// @lc code=end

