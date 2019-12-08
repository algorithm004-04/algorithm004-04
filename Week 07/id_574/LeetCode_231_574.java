package SuanFa.Week07;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 *
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 *
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_231_574 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }

    /**
     * n是2的幂 则它的二进制最高位为1，其他都为0，例如2的三次幂 1000，那么它&（n-1）即1000 & 0111 就为0
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1)) == 0;
    }

}
