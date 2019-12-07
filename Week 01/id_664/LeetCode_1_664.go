package id_664

// 1. 暴力解法 耗时 40ms
func twoSum(nums []int, target int) []int {

	result := make([]int, 2)

	for k, v := range nums {

		result[0] = k

		v := target - v

		for i := k + 1; i < len(nums); i++ {
			if nums[i] == v {
				result[1] = i
				return result
			}
		}
	}

	return nil
}

// 2. 使用map  耗时 4ms
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		if _, ok := m[target-v]; ok {
			return []int{m[target-v], i}
		}
		m[v] = i
	}
	return nil
}
