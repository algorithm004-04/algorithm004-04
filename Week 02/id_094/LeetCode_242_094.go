/*
 * @lc app=leetcode id=242 lang=golang
 *
 * [242] Valid Anagram
 */

// @lc code=start
func isAnagram(s string, t string) bool {
	bytecount := make(map[byte]int)
	for _, b := range []byte(s) {
		bytecount[b] += 1
	}
	for _, b := range []byte(t) {
		bytecount[b] -= 1
	}
	for _, v := range bytecount {
		if v != 0 {
			return false
		}
	}
	return true
}
// @lc code=end

