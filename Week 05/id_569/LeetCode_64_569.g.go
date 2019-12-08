package main

import "fmt"

func main() {
	arr := [][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
	a := minPathSum(arr)
	fmt.Println(a)
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
func minPathSum(a [][]int) int {

	m := len(a)
	n := len(a[0])

	for i := 1; i < n; i++ { //上边界 1 2 3  只能往右走 直接更新最短路径 1 1+2 1+2+3
		a[0][i] = a[0][i] + a[0][i-1]
	}
	for i := 1; i < m; i++ { //左边界  只能往下走 同理
		a[i][0] += a[i-1][0]
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			//从上面和左边过来的路径 选择一下
			a[i][j] = min(a[i-1][j]+a[i][j], a[i][j-1]+a[i][j])
			//直接从原数组修改就行 已经是最短路径了 后边可以直接拿来算
		}
	}

	return a[m-1][n-1]
}
