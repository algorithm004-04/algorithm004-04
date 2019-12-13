/**
 *位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
 * @param {number} n - a positive integer
 * @return {number}
 */
//任何数字和掩码1执行&运算，都可以判断出最低位是0还是1
//如果每次判断将掩码左移一位，只需要判断&掩码不是0就可以
var hammingWeight = function (n) {
  let count = 0
  let one = 1
  for (let i = 0; i < 32; i++) {
    if ((n & one) != 0) count++
    one <<= 1
  }
  return count
};
//如果每次是将n右移一位，直接将count+ (n&1)
var hammingWeight = function (n) {
  let count = 0
  for (let i = 0; i < 32; i++) {
    count += (n & 1)
    n >>= 1
  }
  return count
};

//骚操作：将n & (n-1)总将最低位的1翻转
var hammingWeight = function (n) {
  let count = 0
  while (n !== 0) {
    count++
    n &= (n - 1)
  }
  return count
};