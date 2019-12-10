package week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numsIslands {
    public static void main(String[] args) {
        numsIslands solution2 = new numsIslands();
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands1 = solution2.numIslands(grid1);
        System.out.println(numIslands1);


    }
    //dfs
    public int numIslands_dfs(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        int nrows = grid.length;
        int ncols = grid[0].length;
        int res = 0;
        for(int i = 0;i<nrows;i++) {
            for(int j= 0;j<ncols;j++) {
                if(grid[i][j] ==1)
                    ++res;
                dfs(grid,i,j);
            }
        }
        return res;
    }
    void dfs(char[][] grid,int row,int col) {
        int nrows = grid.length;
        int ncols = grid[0].length;

        if(row <0||col<0||row >= nrows||col >= ncols || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }
    //bfs
    int nrow;
    int ncol;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        nrow = grid.length;
        ncol = grid[0].length;
        int res =0;
        boolean[][] visited = new boolean[nrow][ncol];

        for(int i = 0;i<nrow;i++) {
            for(int j= 0;j<ncol;j++) {
                if(grid[i][j] == '1'&& !visited[i][j]) {
                //if(grid[i][j] == '1'){
                    ++res;
                    //grid[i][j] = '0';
                    Queue<Integer> que = new LinkedList<Integer>();
                    ((LinkedList<Integer>) que).addLast(i * ncol + j);  //格子的 序号
                    visited[i][j] = true;
                    if(res >= 3){
                        for(int l = 0 ;l <4;l++)
                            System.out.println(Arrays.toString(visited[l]));
                    }
                    while (!que.isEmpty()) {
                        int cur = ((LinkedList<Integer>) que).removeFirst();
                        int curx = cur / ncol;
                        int cury = cur % ncol;
                        for (int k = 0; k < 4; k++) {
                            int newx = curx + directions[k][0];
                            int newy = cury + directions[k][1];
                            if(res >= 3) {
                                System.out.println(newx+" "+newy);
                            }
                            if (inArea(newx, newy) && grid[newx][newy] == '1' && !visited[newx][newy]) {
                            //if (inArea(newx, newy) && grid[newx][newy] == '1' ) {
                                ((LinkedList<Integer>) que).add(newx * ncol + newy);
                                //grid[newx][newy] = '0';
                                visited[newx][newy] = true;
                            }
                        }
                    }

                }
            }

        }
        return res;
    }
    public boolean inArea(int x,int y){
        return x >= 0 && x < nrow && y >= 0 && y < ncol;
    }
}

/**
 * public class Solution2 {
 *
 *
 *     private int rows;
 *     private int cols;
 *
 *     public int numIslands(char[][] grid) {
 *         //           x-1,y
 *         //  x,y-1    x,y      x,y+1
 *         //           x+1,y
 *         int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
 *
 *         rows = grid.length;
 *         if (rows == 0) {
 *             return 0;
 *         }
 *         cols = grid[0].length;
 *         boolean[][] marked = new boolean[rows][cols];
 *         int count = 0;
 *         for (int i = 0; i < rows; i++) {
 *             for (int j = 0; j < cols; j++) {
 *                 // 如果是岛屿中的一个点，并且没有被访问过
 *                 // 从坐标为 (i,j) 的点开始进行广度优先遍历
 *                 if (!marked[i][j] && grid[i][j] == '1') {
 *                     count++;
 *                     LinkedList<Integer> queue = new LinkedList<>();
 *                     // 小技巧：把坐标转换为一个数字
 *                     // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
 *                     queue.addLast(i * cols + j);
 *                     // 注意：这里要标记上已经访问过
 *                     marked[i][j] = true;
 *                     while (!queue.isEmpty()) {
 *                         int cur = queue.removeFirst();
 *                         int curX = cur / cols;
 *                         int curY = cur % cols;
 *                         // 得到 4 个方向的坐标
 *                         for (int k = 0; k < 4; k++) {
 *                             int newX = curX + directions[k][0];
 *                             int newY = curY + directions[k][1];
 *                             // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
 *                             if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
 *                                 queue.addLast(newX * cols + newY);
 *                                 // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
 *                                 // 而不是在出队列的时候再标记
 *                                 // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
 *                                 marked[newX][newY] = true;
 *                             }
 *                         }
 *                     }
 *                 }
 *             }
 *
 *         }
 *         return count;
 *     }
 *
 *     private boolean inArea(int x, int y) {
 *         // 等于号这些细节不要忘了
 *         return x >= 0 && x < rows && y >= 0 && y < cols;
 *     }
 *
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


