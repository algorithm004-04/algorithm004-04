class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        if (n == 0) 
            return 0;
        if (m==1 && n==1)
            return grid[m-1][n-1];
        // System.out.println(m+","+n);
        
        int i,j;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; ++j) {
                if (i == 0 && j == 0)
                    continue;
                else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0)
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                else if (i !=0 && j != 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}