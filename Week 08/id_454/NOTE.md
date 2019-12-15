# NOTE

  
##  不同路径的DP

```
dp[i][j] // 状态数组 i表示x坐标   j表示y坐标
if (arr[i][j] == 1) {
    dp[i][j] = 0; // 遇到障碍就是0
} else {
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // dpdpdp
}

```
