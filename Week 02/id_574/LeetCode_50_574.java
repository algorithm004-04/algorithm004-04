package SuanFa.Week02;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 *
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 *
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 *
 *
 * 	-100.0 < x < 100.0
 * 	n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_50_574 {
    public static void main(String[] args) {
        Double x = 2.00000;
        int n = 3;
        System.out.println(myPow1(x,n));
    }

    private static double myPow(Double x, int n) {
        if (n == 0) return 1;
        double sum = 1.000000;
        for (int i=0;i<Math.abs(n);i++) {
            sum = sum*x;
        }
        return n<0 ? 1/sum : sum;
    }

    private static double myPow1(Double x,int n) {
        if (n < 0 ) {
            x = 1/x;
            n = -n;
        }
        return fastPow(x,n);
    }

    private static double fastPow(Double x, int n) {
        if (n == 0) return 1;
        double half = fastPow(x,n/2);
        if(n%2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
}
