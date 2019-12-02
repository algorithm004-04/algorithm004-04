package main

func removeDuplicates(nums []int) int {
	number := nums[0]
	for i:=1; i<len(nums); i++ {
		if number == nums[i] {
			nums = append(nums[:i],nums[i+1:]...)
            i-- 
        }
	}
	return len(nums)
}