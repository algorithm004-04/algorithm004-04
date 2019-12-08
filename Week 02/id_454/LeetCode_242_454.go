/**
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
*/

package HashTable

import (
	"fmt"
	"sort"
	"strings"
)

/**
解题思路
1、利用哈希表，对字母出现次数进行统计，如果相等则为则为字母异位词
2、对字符串进行排序，排序后的两个字符串如果相等则为字母异位词
3、利用替换字符串的方式，如果替换完成之后字符串为空则为字母异位词，性能比较低
4、桶排序也可以
*/

func main() {
	s1, s2 := "abd", "dba"
	b1 := isAnagram(s1, s2)
	b2 := isAnagram2(s1, s2)
	b3 := isAnagram3(s1, s2)

	fmt.Println(b3, b2, b1)
}

//Hashtable方式,最优
func isAnagram(s1 string, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}
	smap := make(map[uint8]int)
	for i := 0; i < len(s1); i++ {
		smap[s1[i]]++
		smap[s2[i]]--
	}
	for _, v := range smap {
		if v != 0 {
			return false
		}
	}

	return true
}

//字符串排序方式
func isAnagram2(s1 string, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}

	bs1 := []byte(s1)
	bs2 := []byte(s2)

	sort.Slice(bs1, func(i, j int) bool {
		return bs1[i] < bs1[j]
	})
	sort.Slice(bs2, func(i, j int) bool {
		return bs2[i] < bs2[j]
	})

	for i, v := range bs1 {
		if v != bs2[i] {
			return false
		}
	}

	return true
}

//替换方式,最慢
func isAnagram3(s1 string, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}
	//循环s1，判断每个字符是否存在于s2，如果存在则替换为空（""）
	for _, s := range s1 {
		if strings.Contains(s2, string(s)) {
			s2 = strings.Replace(s2, string(s), "", 1)
		}
	}
	return s2 == ""
}
