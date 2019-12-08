/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
DP :
1, 子问题
2，状态数组
3，dp方程 dp[n] = min(dp[n-k]) + 1
*/
#include <stdio.h>
#define MYMIN(a,b) ((a < b) ? a : b)
int coinChange(int* coins, int coinsSize, int amount){
  //  int *dp = calloc(amount+1, sizeof(int));
    int dp[12] = {};
    int i;
    int j;
    for (i = 0; i <= amount; i++) {
        dp[i] = amount + 1;
    }
    dp[0] = 0;
    for (i = 1; i <= amount; i++) {
        for (j = 0; j < coinsSize; j++) {
            if (coins[j] <= i) {
                dp[i] = MYMIN(dp[i],dp[i - coins[j]]+1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
void main()
{
    int arry[3] = {1, 2, 5};
    int amount = 11;
    int n;
    n = coinChange(arry, 3, 11);
    printf("%d", n);
}