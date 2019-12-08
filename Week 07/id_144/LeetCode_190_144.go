/*
 * @lc app=leetcode id=190 lang=golang
 *
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * algorithms
 * Easy (32.84%)
 * Likes:    701
 * Dislikes: 249
 * Total Accepted:    208.8K
 * Total Submissions: 618.2K
 * Testcase Example:  '00000010100101000001111010011100'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100
 * represents the unsigned integer 43261596, so return 964176192 which its
 * binary representation is 00111001011110000010100101000000.
 *
 *
 * Example 2:
 *
 *
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101
 * represents the unsigned integer 4294967293, so return 3221225471 which its
 * binary representation is 10111111111111111111111111111111.
 *
 *
 *
 * Note:
 *
 *
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as signed integer type and
 * should not affect your implementation, as the internal binary representation
 * of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 2 above the input represents the signed
 * integer -3 and the output represents the signed integer -1073741825.
 *
 *
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 */

// @lc code=start
/*
num: 11111111111111111111111111111101
for begin:
	num: 1111111111111111111111111111110, ans: 1, t: 31
	num: 111111111111111111111111111111, ans: 10, t: 30
	num: 11111111111111111111111111111, ans: 101, t: 29
	num: 1111111111111111111111111111, ans: 1011, t: 28
	num: 111111111111111111111111111, ans: 10111, t: 27
	num: 11111111111111111111111111, ans: 101111, t: 26
	num: 1111111111111111111111111, ans: 1011111, t: 25
	num: 111111111111111111111111, ans: 10111111, t: 24
	num: 11111111111111111111111, ans: 101111111, t: 23
	num: 1111111111111111111111, ans: 1011111111, t: 22
	num: 111111111111111111111, ans: 10111111111, t: 21
	num: 11111111111111111111, ans: 101111111111, t: 20
	num: 1111111111111111111, ans: 1011111111111, t: 19
	num: 111111111111111111, ans: 10111111111111, t: 18
	num: 11111111111111111, ans: 101111111111111, t: 17
	num: 1111111111111111, ans: 1011111111111111, t: 16
	num: 111111111111111, ans: 10111111111111111, t: 15
	num: 11111111111111, ans: 101111111111111111, t: 14
	num: 1111111111111, ans: 1011111111111111111, t: 13
	num: 111111111111, ans: 10111111111111111111, t: 12
	num: 11111111111, ans: 101111111111111111111, t: 11
	num: 1111111111, ans: 1011111111111111111111, t: 10
	num: 111111111, ans: 10111111111111111111111, t: 9
	num: 11111111, ans: 101111111111111111111111, t: 8
	num: 1111111, ans: 1011111111111111111111111, t: 7
	num: 111111, ans: 10111111111111111111111111, t: 6
	num: 11111, ans: 101111111111111111111111111, t: 5
	num: 1111, ans: 1011111111111111111111111111, t: 4
	num: 111, ans: 10111111111111111111111111111, t: 3
	num: 11, ans: 101111111111111111111111111111, t: 2
	num: 1, ans: 1011111111111111111111111111111, t: 1
	num: 0, ans: 10111111111111111111111111111111, t: 0
for end
res: 10111111111111111111111111111111
*/
func reverseBits(num uint32) uint32 {
	var ans uint32 = 0
	t := 32
	for t > 0 {
		ans <<= 1      // 每次将 ans 向高位移一位
		ans |= num & 1 // 取 num 最后一位，更新到 ans
		num >>= 1      // num 右移一位
		t--            // 以此类推，直到循环完 32 位
	}
	return ans
}

// @lc code=end

