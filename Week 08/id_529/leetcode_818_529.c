#define MAX 0x7fffffff
int dp[10000];
#define MYMIN(a, b) ((a) < (b) ? (a) : (b))
int racecar(int target)
{
    dp[0] = 0;
    int i,j;
    int cnt1 = 1;
    int k, cnt2;
    for ( i = 1; i <= target; ++i) {
        
        dp[i] = MAX;
            int j = 1, cnt1 = 1;
            for (; j < i; j = (1 << ++cnt1) - 1) {
                for (int k = 0, cnt2 = 0; k < j; k = (1 << ++cnt2) - 1) {
                    dp[i] = MYMIN(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)]);
             //      printf("%d ,  %d\n",dp[i], i);
                }
            }
            dp[i] = MYMIN(dp[i], cnt1 + (i == j ? 0 : 1 + dp[j - i]));
       // printf("%d ,  %d\n",dp[i], i);
    }
    return dp[target];
}