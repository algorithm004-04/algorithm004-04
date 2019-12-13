/**
 * LeetCode_300_034
 * 最长上升子序列
 * @Author blackberry
 * @Date 2019/12/8 4:50 PM
 **/
public class LeetCode_300_034 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 1;

        int maxans = 1;
        for (int i = 1; i < len;  i ++) {
            int maxval = 0;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
