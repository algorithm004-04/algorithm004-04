//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
// Related Topics Array Dynamic Programming


/**
 * @Author: wangchuande
 * @Date: 2019/10/20 20:37
 */
public class LeetCode_64_314 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] testData = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(solution.minPathSum(testData));

    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                    if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
                    if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
            return grid[m - 1][n - 1];
        }
    }

}

