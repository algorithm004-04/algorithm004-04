package week_05.lesson12;

import java.util.Arrays;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        /*int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0,dp[i - 1]) + nums[i];
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];*/
        int pre = nums[0];
        int result = pre;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(0,pre) + nums[i];
            result = Math.max(result,pre);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
