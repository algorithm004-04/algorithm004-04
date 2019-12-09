/**
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
*/

/**
解题思路
1、排序方式，把排序后的字符串作为key，如果为异位词的话则key相等，从而达到分组
2、
*/

package HashTable

import (
	"fmt"
	"sort"
	"strings"
)

func main() {
	var strs = []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	strss := groupAnagrams(strs)
	fmt.Println(strss)
}

func groupAnagrams(strs []string) [][]string {
	if len(strs) <= 1 {
		return [][]string{strs}
	}

	res := make([][]string, 0)
	help := make(map[string][]string)

	for _, v := range strs {
		s := strings.Split(v, "")
		sort.Strings(s)
		sortStr := strings.Join(s, "")
		help[sortStr] = append(help[sortStr], v)
	}

	for _, v := range help {
		res = append(res, v)
	}
	return res
}
