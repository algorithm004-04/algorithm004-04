/**2的幂https://leetcode-cn.com/problems/power-of-two/
 * @param {number} n
 * @return {boolean}
 */
//条件1： n & (n - 1) === 0
//因为n的最高位为1，其余所有位为0
//n - 1的最高位为0，其余所有位为1
//条件2： n > 0
var isPowerOfTwo = function (n) {
  return n > 0 && ((n & n - 1) === 0)
};

//二进制正负数表示，一般用补码表示
//补码与反码https://www.cnblogs.com/author/p/8954127.html
// 正数00010 & 负数11110  === 00010
var isPowerOfTwo = function (n) {
  return n > 0 && (n & -n === n)
};