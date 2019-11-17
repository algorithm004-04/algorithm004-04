package week_03.lesson10;

import java.util.LinkedList;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        //把1冲成0，然后把1边上的1也冲成0，然后岛屿加1
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    //dfs(grid,r,c);

                    grid[r][c] = '0';
                    LinkedList<Integer> landsQueue = new LinkedList<>();
                    landsQueue.add(r * nc + c);
                    while (!landsQueue.isEmpty()) {
                        int id = landsQueue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            landsQueue.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            landsQueue.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            landsQueue.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            landsQueue.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }

                    }
                }
            }
        }
        return num_islands;
    }

    //深度优先搜索，把上下左右的岛屿也就是1冲掉，改成0
    private static void dfs(char[][] grid,int r,int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r - 1,c);
        dfs(grid,r + 1,c);
        dfs(grid,r,c - 1);
        dfs(grid,r,c + 1);
    }

    public static void main(String[] args) {
        char[][] lands = new char[4][5];
        char[] nc0 = new char[]{'1','1','1','1','0'};
        char[] nc1 = new char[]{'1','1','0','1','0'};
        char[] nc2 = new char[]{'1','1','0','0','0'};
        char[] nc3 = new char[]{'0','0','0','0','0'};
        lands[0] = nc0;
        lands[1] = nc1;
        lands[2] = nc2;
        lands[3] = nc3;

        System.out.println(numIslands(lands));
    }

}
