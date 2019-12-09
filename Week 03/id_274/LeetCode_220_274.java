import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int numIslands1(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }  

    int nr = grid.length;
    int nc = grid[0].length;

    int num_islands = 0;
    for (int r = 0; r < nr; r++) {
      for(int c = 0; c < nc; c++) {
        if (grid[r][c] == '1') {
          ++num_islands;
          dfs(grid, r, c);
        }
      }
    }

    return num_islands;
  }
  void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }
    grid[r][c] = 0;
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1); 

  }

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
          ++num_islands;
          grid[r][c] = '0';

          Queue<Integer> queue = new LinkedList<>();
          queue.add( r * nc + c);
          while(!queue.isEmpty()) {
            int id = queue.remove();
            int row = id / nc;
            int col = id % nc;

            if (row - 1 >= 0 && grid[row - 1][col] == '1'){
              queue.add((row - 1) * nc + col);
              grid[row - 1][col] = '0';
            }

            if (row + 1 < nr && grid[row + 1][col] == '1') {
              queue.add((row + 1) * nc + col);
              grid[row + 1][col] = '0';
            }

            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
              queue.add(row * nc + col - 1);
              grid[row][col - 1] = '0';
            }

            if (col + 1 < nc && grid[row][col + 1] == '1') {
              queue.add(row * nc + col + 1);
              grid[row][col + 1] = '0';
            }


          }
        }
      }
    }


    return num_islands;
  }
}