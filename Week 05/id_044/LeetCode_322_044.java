package week_05.lesson12;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin :
                    coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }

}
