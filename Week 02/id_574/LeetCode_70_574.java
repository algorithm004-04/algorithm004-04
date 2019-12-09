package SuanFa.Week02;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_70_574 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStarts2(n));

    }

    /**
     * 递归，看似简单，但是没有利用缓存，中间产生了多次相同的值
     * @param n
     * @return
     */
    private static int climbStarts(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStarts(n-1)+climbStarts(n-2);
    }

    /**
     * 利用缓存，只记录中间常数级的值，空间占用O(1)
     * @param n
     * @return
     */
    private static int climbStarts1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1;
        int second = 2;
        for (int i=3;i<=n;i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 利用数组记录中间产生的值（缓存），但是这样会缓存O(n)的数组
     * @param n
     * @return
     */
    private static int climbStarts2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int steps[] = new int [n+1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i= 3; i<=n;i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}


