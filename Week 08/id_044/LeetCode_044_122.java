package week_08.lesson19;

public class BuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, temp - prices[i]);
        }
        return dp0;
    }

}
