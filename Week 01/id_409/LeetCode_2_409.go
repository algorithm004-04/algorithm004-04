func twoSum(nums []int, target int) []int {
	var resultMap = make(map[int]int)
	for i, num := range nums {
		if v, ok := resultMap[num]; ok {
			return []int{v, i}
		} else {
			resultMap[target-num] = i
		}
	}
	return []int{}
}