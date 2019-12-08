package main

import (
	"fmt"
)

func main() {

	nums := []int{1, 2, 2, 2, 7, 9, 11, 11, 13, 13, 14}
	//nums := []int{1, 1}
	r := removeDuplicates(nums)
	fmt.Println(r)
}

//1双指针法
func removeDuplicates(nums []int) int {
	for i := 1; i < len(nums); i++ {

		if nums[i-1] == nums[i] {
			nums = append(nums[:i], nums[i+1:]...)
			fmt.Println(i, nums[i-1], nums[i], nums)
			i--
		}
	}
	return len(nums)
}
