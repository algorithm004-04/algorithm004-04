package main

import (
	"fmt"
	"sort"
)

func main() {
	arr1 := []int{1,2,3,4,3}
	arr2 := []int{2,7,6,4,5}
	a := relativeSortArray(arr1,arr2)
	fmt.Println(a)
}
// 对arr1中元素排序，符合arr2中的顺序，没出现在arr2的，就按照升序排
func relativeSortArray(arr1 []int, arr2 []int) []int {
	pre := make(map[int]int)
	count := 0
	for i := 0; i < len(arr2); i++ {
		if _, ok := pre[arr2[i]]; !ok {
			pre[arr2[i]] = count
			count++
		}
	}
	//n := len(arr1)
	sort.Slice(arr1, func(i, j int) bool {
		v_i, ok_i := pre[arr1[i]]
		v_j, ok_j := pre[arr1[j]]
		if ok_i && ok_j {
			return v_i < v_j
		}
		if ok_i && !ok_j {
			return true
		}
		if !ok_i && ok_j {
			return false
		}
		return arr1[i] < arr1[j]

	})
	return arr1
}
