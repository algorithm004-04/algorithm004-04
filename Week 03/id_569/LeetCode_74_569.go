package main

import (
	"fmt"
)

func main() {

	//初始化数组
	arr := [][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}

	//坐标偏移
	r := searchMatrix(arr, 3)
	fmt.Println(r)
}
func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}
	columnIdx := firstGreaterThanTarget(matrix, target)
	return halfsearch(matrix[columnIdx], target)
}

func firstGreaterThanTarget(matrix [][]int, target int) int {
	rowlen := len(matrix[0])
	left := 0
	right := len(matrix) - 1
	mid := left + (right-left)>>1
	for left <= right {
		mid = left + (right-left)>>1
		midNum := matrix[mid][rowlen-1]
		if midNum >= target {
			if mid == 0 || matrix[mid-1][rowlen-1] < target {
				return mid
			}
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return mid
}

func halfsearch(r []int, target int) bool {
	left := 0
	right := len(r) - 1
	for left <= right {
		mid := left + (right-left)>>1
		if r[mid] == target {
			return true
		} else if r[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return false
}
