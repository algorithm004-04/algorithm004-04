// 思路：从后向前遍历，寻找是否存在位置i能到达目的位置d
// 如果可以则修改能到达目标位置为i，依次向前遍历，
// 如果最后的目标位置为0时则证明可以到达最后一个位置

func canJump(nums []int) bool {
	// start指当前位置，end指要到达的目标位置
	start, end := len(nums)-2, len(nums)-1
	for start >= 0 {

		// 如果能在位置start处到达目标位置end，则修改目标位置end = start
		if nums[start]+start >= end {
			end = start
		}
		start--
	}
	return end == 0
}