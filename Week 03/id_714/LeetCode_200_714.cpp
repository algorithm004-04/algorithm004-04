class Solution
{
public:
  int numIslands(vector<vector<char>> &grid)
  {
    int row = grid.size();
    if (row == 0)
      return 0;
    int col = grid[0].size();
    int island = 0;

    // 1. DFS
    // for(int r = 0; r < row; r++){
    //     for(int c = 0; c < col; c++){
    //         if(grid[r][c] == '1'){
    //             island++;
    //             dfs(grid,r,c);
    //         }
    //     }
    // }

    // 2. BFS
    queue<pair<int, int>> q;
    for (int r = 0; r < row; r++)
    {
      for (int c = 0; c < col; c++)
      {
        if (grid[r][c] == '1')
        {
          island++;
          q.push({r, c});
          grid[r][c] == '0';
          while (!q.empty())
          {
            auto cur = q.front();
            cout << cur.first << " " << cur.second << endl;
            q.pop();
            if (cur.first - 1 >= 0 && grid[cur.first - 1][cur.second] == '1')
            {
              q.push({cur.first - 1, cur.second});
              grid[cur.first - 1][cur.second] = '0';
            }
            if (cur.first + 1 < grid.size() && grid[cur.first + 1][cur.second] == '1')
            {
              q.push({cur.first + 1, cur.second});
              grid[cur.first + 1][cur.second] = '0';
            }
            if (cur.second - 1 >= 0 && grid[cur.first][cur.second - 1] == '1')
            {
              q.push({cur.first, cur.second - 1});
              grid[cur.first][cur.second - 1] = '0';
            }
            if (cur.second + 1 < grid[0].size() && grid[cur.first][cur.second + 1] == '1')
            {
              q.push({cur.first, cur.second + 1});
              grid[cur.first][cur.second + 1] = '0';
            }
          }
        }
      }
    }

    return island;
  }

private:
  void dfs(vector<vector<char>> &grid, int r, int c)
  {
    int row = grid.size();
    int col = grid[0].size();

    grid[r][c] = '0';
    if (r - 1 >= 0 && grid[r - 1][c] == '1')
      dfs(grid, r - 1, c);
    if (r + 1 < row && grid[r + 1][c] == '1')
      dfs(grid, r + 1, c);
    if (c - 1 >= 0 && grid[r][c - 1] == '1')
      dfs(grid, r, c - 1);
    if (c + 1 < col && grid[r][c + 1] == '1')
      dfs(grid, r, c + 1);
  }
};