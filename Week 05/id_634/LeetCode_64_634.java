class Solution {
    // public int minPathSum(int[][] grid) {
    //     /*
    //     * DP 
    //     * 1.重复性（分治） 
    //     * 2.定义状态数组  int[][] dp
    //     * 3.DP方程：dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
    //     */
    //     if(grid.length == 0){
    //         return 0;
    //     }
    //     int[][] dp = new int[grid.length][grid[0].length];
    //     for(int i = 0;i < dp.length;i++) {
    //         for(int j = 0; j < dp[i].length;j++) {
    //             if(i == 0 && j != 0){
    //                 dp[i][j] = dp[i][j-1] + grid[i][j];
    //             } else if(j == 0 && i != 0) {
    //                 dp[i][j] = dp[i-1][j] + grid[i][j];
    //             } else if(i == 0 && j == 0) {
    //                 dp[i][j] = 0 + grid[i][j];
    //             } else {
    //                 dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
    //             }
    //         }
    //     }
    //     return dp[grid.length-1][grid[0].length-1];
    // }
    
    // public int minPathSum(int[][] grid) {
    //     /*
    //     * DP 
    //     * 1.重复性（分治） 
    //     * 2.定义状态数组  int dp[]
    //     * 3.DP方程：
    //     * dp[j] = Math.min(dp[j-1], dp[j]) + (row ? grid[i][j]:grid[j][i]);
    //     */
    //     if(grid.length == 0) {
    //         return 0;
    //     }
    //     int large = Math.max(grid.length, grid[0].length); //得到行与列的较大值为large
    //     int small = Math.min(grid.length, grid[0].length); //得到行与列的较小值为small
    //     boolean row = large == grid.length; //行数是不是大于列数
    //     int[] dp = new int[small];//状态数组仅为行或者列的最小值
    //     dp[0] = grid[0][0];
    //     for (int i = 1; i < small; i ++) {
    //        dp[i] = dp[i-1] + (row ? grid[0][i] : grid[i][0]); 
    //     }
    //     for(int i = 1; i < large; i++) {
    //         dp[0] = dp[0] + (row ? grid[i][0] : grid[0][i]);
    //         for(int j = 1; j < small; j++) {
    //             dp[j] = Math.min(dp[j-1], dp[j]) + (row ? grid[i][j]:grid[j][i]);
    //         }
    //     }
    //     return dp[small - 1];
    // }
    
    //简化
    public int minPathSum(int[][] grid) {
       /*
        * DP 
        * 1.重复性（分治） 
        * 2.定义状态数组  int dp[]
        * 3.DP方程：
        * dp[j] = Math.min(dp[j-1], dp[j]) + grid[j][i];
        */
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            dp[i] = dp[i-1] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++) {
            dp[0] += grid[0][i];
            for(int j = 1; j < grid.length; j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[j][i];
            }
        }
        return dp[grid.length - 1];
    }
}