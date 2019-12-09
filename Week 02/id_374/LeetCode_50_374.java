package algorithm.homework.week02;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_50_374 {

    public static void main(String[] args) {
        LeetCode_50_374 l50 = new LeetCode_50_374();
        System.out.println(l50.myPow2(2.10000, 3));
    }

    /**
     * 递归
     * 数值过大会引起栈溢出
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1.0;
        }
        return n >= 0 ? x * myPow1(x, n - 1) : 1 / (x * myPow1(x, -n - 1));
    }

    /**
     * 分治递归
     * eve:每次求x^(n/2)
     * odd:每次求(n-1)/2
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}
