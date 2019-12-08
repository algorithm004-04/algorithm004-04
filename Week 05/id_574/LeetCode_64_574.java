package SuanFa.Week05;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_64_574 {
    public static void main(String[] args) {
        int grid[][] = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum1(grid));
        System.out.println(minPathSum2(grid));
    }

    /**
     * 暴力法，要么向下要么向右走，两个方向取权重最小的走
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid) {
        return calculate(grid,0,0);
    }

    private static int calculate(int[][] grid,int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid,i+1,j),calculate(grid,i,j+1));
    }

    /**
     * 左上角,在原数组上操作
     * @param grid
     * @return
     */
    private static  int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                if (i == 0 && j != 0) {
                    grid[0][j] = grid[0][j] + grid[0][j-1];
                }
                else if (j == 0 && i != 0) {
                    grid[i][0] = grid[i][0] + grid[i-1][0];
                }
                else if (i != 0 && j !=0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }

    /**
     * 新增DP二维数组，不用再原数组上操作
     * @param grid
     * @return
     */
    private static  int minPathSum2(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = grid.length-1; i>=0; i--) {
            for (int j = grid[0].length-1; j>=0; j--) {
                if (i == grid.length - 1 && j == grid[0].length-1) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == grid.length-1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
                else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else if (i != grid.length-1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
