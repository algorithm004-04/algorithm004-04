package SuanFa.Week03;


/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Neo
 */
public class LeetCode_200_574 {
    //方向
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    //标记数组
    private static boolean[][] marked;
    //行数
    private static int rows;
    //列数
    private static int cols;
    private static char[][] grids;

    private static int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        grids = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //如果这个岛屿没有被访问过进行DFS
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }


    private static void dfs(int i, int j) {
        marked[i][j] = true;
        //找该点的上下左右位置坐标
        for (int k =0; k<4;k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX,newY) && grids[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX,newY);
            }
        }
    }

    private static boolean inArea(int x, int y) {
        return x>=0 && x<rows && y >=0 && y< cols;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = numIslands(grid2);
        System.out.println(numIslands2);
    }
}
