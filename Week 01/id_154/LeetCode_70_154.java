//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class climbStairs {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(n, memo);
    }

    public int climb_Stairs(int n, int memo[]) {
        if (n < 3) {
            memo[n] = n;
        } else {
            if (memo[n] == 0)
                memo[n] = climb_Stairs(n - 2, memo) + climb_Stairs(n - 1, memo);
        }

        return memo[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
