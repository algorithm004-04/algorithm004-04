public class LeetCode_70_climbing_stairs {

    /*

        爬楼梯问题


     */


    /*
        暴力求解
            将所有的情况列举出来，然后利用终止条件去过滤
            这种情况下时间复杂度是O(2^n) 空间复杂度是O(n)
     */
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    /*
        因暴力求解递归树造成的冗余，可以采用记忆化递归
        这种情况下时间复杂度为O(n)  空间复杂度是O(n)

     */
    public int climbStairs1(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    /*
        动态规划，它的最优解可以从其子问题最优解来进行构造
            dp[i] = dp[i - 1] + dp[i - 2]

        时间复杂度O(n) 空间复杂度O(n)


     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /*
        斐波那契数
            时间复杂度O(n) 空间复杂度O(1)

     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;

    }



}
