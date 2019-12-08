/**
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
*/

/**
解题思路
1、暴力法，两层嵌套循环逐一判断，时间复杂度O(n^2)
2、利用哈希表，时间复杂度O(n)
*/

package HashTable

import "fmt"

func main() {
	sums := []int{2, 7, 11, 15}
	target := 9
	res := twoSum(sums, target)
	//最优解法
	res2 := twoSum(sums, target)
	fmt.Println(res, res2)
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int, len(nums))
	res := []int{}
	for k, v := range nums {
		if _, val2 := m[target-v]; val2 {
			res = []int{k, m[target-v]}
			break
		}
		m[v] = k
	}

	return res
}

//最优解
func twoSum2(nums []int, target int) []int {
	maps := make(map[int]int)
	news := make([]int, 0)

	for i, v := range nums {
		diff := target - v

		if _, st := maps[diff]; st {
			news = append(news, maps[diff])
			news = append(news, i)
		}
		maps[v] = i
	}

	return news
}
