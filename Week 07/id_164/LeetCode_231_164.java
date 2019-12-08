/**
 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if ((n & (n - 1)) == 0) {
            return true;
        }

        return false;
    }
}
