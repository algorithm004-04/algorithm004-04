class Solution {
    
    //1.dp状态数组
//     public int lengthOfLIS(int[] nums) {
//         if(nums==null || nums.length==0){
//             return 0;
//         }
//         //状态数组 0-i的最长序列值
//         int[] dp = new int[nums.length];     
//         int max = 1;
//         for(int i = 0; i < nums.length; i++) {
//             dp[i] = 1;
//             for(int j = 0; j < i; j++) {
//                 //如果当前0-i子序列内第j个数字小于nums[i],则更新0-i的最长序列值
//                 if(nums[j] < nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                     max = Math.max(dp[i], max);
//                 }
//             }
//         }
//         return max;
//     }
    
    //2.dp状态变量
    public int lengthOfLIS(int[] nums) {
        int max = 0, expandedLen, x;
        for(int i = 0; i < nums.length; i++) {
            x = nums[i];
            if (max < 1 || x > nums[max-1]) {
                nums[max++] = x;
            } else if ((expandedLen = Arrays.binarySearch(nums, 0, max, x)) < 0) {
                nums[-(expandedLen + 1)] = x;
            }
        }
        return max;
    }
}