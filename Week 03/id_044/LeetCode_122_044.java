package week_03.lesson10;

public class BestTimeBuySellStock {


    public static int maxProfit(int[] prices) {

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                max += tmp;
            }
        }
        return max;

    }

    public static void main(String[] args) {

    }

}
