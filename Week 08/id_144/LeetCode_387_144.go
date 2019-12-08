/*
 * @lc app=leetcode id=387 lang=golang
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.62%)
 * Likes:    1312
 * Dislikes: 92
 * Total Accepted:    354.5K
 * Total Submissions: 694.1K
 * Testcase Example:  '"leetcode"'
 *
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 *
 *
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */

// @lc code=start
func firstUniqChar(s string) int {
	cache := map[rune]int{}
	for _, v := range s {
		cache[v]++
	}
	for i, v := range s {
		if cache[v] == 1 {
			return i
		}
	}
	return -1
}

// @lc code=end

