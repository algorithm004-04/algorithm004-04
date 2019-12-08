public class LeetCode_200_009 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        LeetCode_200_009 test = new LeetCode_200_009();
        char[][] grid = new char[1][1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = 0;
            }
        }
        grid[0][0] = '1';
//        grid[0][1] = '1';
//        grid[1][0] = '1';
//        grid[1][1] = '1';
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                System.out.println(new Integer(grid[i][j]));
//            }
//        }
        System.out.println(test.numIslands(grid));
    }

    /**
     * DFS
     * floodfill 碰到1时，岛屿数加一，并且用dfs把与它相连的1全部变为0，以此类推。
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        //terminator
        if (grid[i][j] == '0') {
            return;
        }
        //process
        grid[i][j] = '0';

        //drill down
        for (int k = 0; k < dx.length; k++) {
            //if...
            if ((i + dx[k]) >= 0 && (i + dx[k]) < grid.length && (j + dy[k]) >= 0 && (j + dy[k]) < grid[0].length) {
                dfs(grid, i + dx[k], j + dy[k]);
            }
        }
    }
}
