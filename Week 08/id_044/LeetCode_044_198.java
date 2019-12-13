package week_08.lesson19;

public class HouseRobber {

    public int rob(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        //第0天没偷的金额为0，偷了金额为数组的第一个元素
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            //如果第i天没偷，就等于第i-1天偷了或没偷金额的最大值
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            //如果第i天偷了，第i-1天就不能偷，然后加上之前偷的
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        //返回最后一在偷或者没偷的最大值
        return Math.max(dp[n - 1][0],dp[n - 1][1]);

    }

}
