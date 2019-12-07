/*
 * @lc app=leetcode id=191 lang=golang
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
func hammingWeight(num uint32) int {
    var count int
    for num > 0 {
        num &= (num-1)
        count++
    }
    return count
}
// @lc code=end

