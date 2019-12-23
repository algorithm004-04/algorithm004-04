class Solution {
    public int maxProfit(int[] prices) {
              if (prices==null) {
            return 0;
        }
        if (prices.length==0) {
            return 0;
        }
        int[]dp = new int[prices.length];
        dp[0] = 0;
        int max = dp[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]) {
                dp[i] = prices[i]-prices[i-1];

            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum+=dp[i];
        }
        return sum;
    }
    
}
