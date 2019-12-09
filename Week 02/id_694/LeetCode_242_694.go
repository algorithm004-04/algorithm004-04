
/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

/*
func isAnagram(s string, t string) bool {
	len1 := len(s)
	len2 := len(t)
	if len1 != len2 {
		return false
	}
	return sortedStrs(s) == sortedStrs(t)
}

func sortedStrs(str string) string {
	s := strings.Split(str, "")
	sort.Strings(s)
	return strings.Join(s, "")
}
*/

// @lc code=start
func isAnagram(s string, t string) bool {
	len1 := len(s)
	len2 := len(t)
	if len1 != len2 {
		return false
	}

	m := make(map[byte]int, len1)
	for k := range s {
		m[s[k]]++
		m[t[k]]--
	}

	for _, v := range m {
		if v > 0 {
			return false
		}
	}
	return true
}

// @lc code=end

