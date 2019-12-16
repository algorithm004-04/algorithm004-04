/*
https://leetcode-cn.com/problems/house-robber/
*/
#include <malloc.h>
#include <stdio.h>
#if 0
#define N 100
int dp[N][2] = {{0}};
int tmp;
#define MAX(a, b) ((a) > (b) ? (a) : (b))
int rob(int* nums, int numsSize)
{
    int maxValue = 0;
    int i;
    if (nums == NULL || numsSize == 0) {
        return 0;
    }
    memset(dp, 0, sizeof(dp));
    dp[0][0] = 0;
    dp[0][1] = nums[0];
    maxValue = MAX(maxValue, dp[0][1]);
    for (i = 1 ; i < numsSize; i++) {
        dp[i][0] = MAX(dp[i-1][1], dp[i-1][0]);
        dp[i][1] = dp[i-1][0] + nums[i];
    }
    return MAX(dp[numsSize-1][0], dp[numsSize-1][1]);
}
#endif
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define N 100
int dp[N] = {0};
int rob(int* nums, int numsSize)
{
    int max;
    if (nums == NULL|| numsSize == 0) {
        return 0;
    }
    if (numsSize == 1) {
        return nums[0];
    }
    memset(dp, 0, sizeof(dp));
    dp[0] = nums[0];
    dp[1] = MAX(nums[0], nums[1]);
    max = dp[1];
    for (int i = 2; i <numsSize; i++) {
        dp[i] = MAX(dp[i-2]+nums[i], dp[i-1]);
        max = MAX(res, dp[i]);
    }
    return max;
}

void main()
{
    int nums[4] = {2,1,1,2};
    int n;
    n = rob(nums, 4);
    printf("%d", n);
}