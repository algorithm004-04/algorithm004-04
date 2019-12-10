package id_664

// 双指针移动 耗时84ms
func moveZeroes(nums []int)  {
	// 双层判断
	k := 0
	for j :=0;j<len(nums);j++{
		if nums[j]!=0{
			if j !=k{
				nums[k],nums[j] = nums[j],nums[k]
				k++
			}else{
				k++
			}
		}
	}
}