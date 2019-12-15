package week_08.lesson19;

public class BuyAndSellStockThree {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        int dpPre = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0,dp1 + prices[i]);
            dp1 = Math.max(dpPre,dpPre - prices[i]);
            dpPre = temp;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2,1,2,0,1};
        System.out.println(maxProfit(prices));
    }

}
