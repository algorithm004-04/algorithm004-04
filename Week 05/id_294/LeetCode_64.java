package week05;

public class LeetCode_64 {

    /**
     * 二维数组
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int totalRow = grid.length;
        int totalCol = grid[0].length;
        int[][] dp = new int[totalRow][totalCol];
        for(int row=0; row < totalRow; row++) {
            dp[row][0] = (row > 0 ? dp[row-1][0] : 0) + grid[row][0];
        }
        for(int col=0; col < totalCol; col++) {
            dp[0][col] = (col > 0 ? dp[0][col-1] : 0) + grid[0][col];
        }

        for(int row = 1; row < totalRow; row ++) {
            for(int col = 1; col < totalCol; col ++) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }
        return dp[totalRow-1][totalCol-1];
    }

    /**
     * 一维数组
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {
        if (grid.length == 0) return 0;
        int totalRow = grid.length;
        int totalCol = grid[0].length;
        int[] dp = new int[totalCol];
        for(int row = 0; row < totalRow; row ++) {
            for(int col = 0; col < totalCol; col ++) {
                //这里更新前，dp里存的是上一行的数据，然后依次更新成当前行对应列的数据
                if (row == 0) {
                    dp[col] = (col > 0 ? dp[col-1] : 0) + grid[row][col];
                } else {
                    dp[col] = Math.min(dp[col], (col > 0 ? dp[col-1] : Integer.MAX_VALUE)) + grid[row][col];
                }
            }
        }
        return dp[totalCol-1];
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = new int[][]{{1,2},{1,1}};

        int sum = minPathSum2(grid);
    System.out.println(sum);
    }
}
