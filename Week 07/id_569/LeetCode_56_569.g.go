package main

import (
	"fmt"
	"sort"
)

func main() {
	arr := [][]int{{1,3},{2,6},{8,10},{15,18}}
	r := merge(arr)
	fmt.Println(r)
}
func merge(intervals [][]int) [][]int {
	n := len(intervals)
	sort.Slice(intervals, func(a, b int) bool {
		return intervals[a][0] < intervals[b][0]
	})

	for i := 0;i < n-1;i++ {
		if intervals[i][1] >= intervals[i+1][0] {
			if intervals[i+1][1] > intervals[i][1] {
				intervals[i][1] = intervals[i+1][1]
			}
			intervals = append(intervals[:i+1], intervals[i+2:]...)
			i--
			n--
		}
	}
	return intervals
}
