/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int rows;
    private int columns;
    private static final int[] directions = {0, 1, 0, -1, 0};
    private char[][] grid;

    private boolean isNotIsland(int r, int c) {
        return r < 0 || r == rows || c < 0 || c == columns || grid[r][c] == '0';
    }

    // union-find
    // time O(M*N)
    // space O(M*N)
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        columns = grid[0].length;
        this.grid = grid;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == '1') {
                    islands += dfs(r, c);
                }
            }
        }

        return islands;
    }

    private int dfs(int r, int c) {
        if (isNotIsland(r, c)) {
            return 0;
        }
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(r + directions[i], c + directions[i+1]);
        }

        return 1;
    }
}
// @lc code=end
