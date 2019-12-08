import java.net.NoRouteToHostException;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.63%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    36K
 * Total Submissions: 78.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 *
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num_islands = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(r * nc + c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        // 向上找
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        // 向下找
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            queue.offer((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        // 向左找
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        // 向右找
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            queue.offer(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }
}
// @lc code=end
