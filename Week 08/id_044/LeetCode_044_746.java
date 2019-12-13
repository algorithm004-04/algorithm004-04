package week_08.lesson19;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {

        if (null == cost || cost.length == 0) {
            return 0;
        }
        int count = cost.length;
        int[] dp = new int[count + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < count; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1],dp[i - 2]);
        }
        return Math.min(dp[count - 1],dp[count - 2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0,0,1,1}));
    }

}
