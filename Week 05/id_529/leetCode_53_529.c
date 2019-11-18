/* 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
1,分治，sum(i) = max(sum[i-1], 0) + nums[i]
2,状态数组定义f[i]
3,状态方程 f[i] = max(f[i-1], 0) + nums[i]
*/
#define MYMAX(a, b) ((a) > (b) ? (a) : (b))
int maxSubArray(int* nums, int numsSize){
    int *dp = calloc(numsSize, sizeof(int));
    int i;
    int sum = 0;
    if (nums == NULL || numsSize == 0) {
        return 0;
    }
    dp[0] = nums[0];
    sum  = dp[0];
    for (i = 1; i < numsSize; i++) {
        dp[i] = MYMAX(dp[i-1], 0) + nums[i];
        sum = MYMAX(sum, dp[i]);
    }
    return sum;
}