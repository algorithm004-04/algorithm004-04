package SuanFa.Week07;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 *
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 *
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_191_574 {
    private static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i=0;i<32;i++) {
            if ((n&mask) != 0) {
                bits++;
            }
            n <<=1;
        }
        return bits;
    }

    /**
     * 每次把最后一位的1置为0并累加一次一，当值为0结束
     * n&(n-1)
     * @param n
     * @return
     */
    private static int hammingWeight1(int n) {
        int counts = 0;
        while (n != 0) {
            counts ++;
            n &= (n-1);
        }
        return counts;
    }
}
