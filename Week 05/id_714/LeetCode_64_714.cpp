class Solution
{
public:
  int minPathSum(vector<vector<int>> &grid)
  {
    if (grid.size() == 0 || grid[0].size() == 0)
    {
      return 0;
    }
    int row_cnt = grid.size();
    int col_cnt = grid[0].size();
    int board[row_cnt][col_cnt];
    memset(board, 0, sizeof(board));
    board[0][0] = grid[0][0];
    for (int i = 0; i < row_cnt; i++)
    {
      for (int j = 0; j < col_cnt; j++)
      {
        if (i == 0 && j == 0)
          continue;
        if (i - 1 < 0)
        {
          board[i][j] = board[i][j - 1] + grid[i][j];
        }
        else if (j - 1 < 0)
        {
          board[i][j] = board[i - 1][j] + grid[i][j];
        }
        else
        {
          board[i][j] = min(board[i - 1][j], board[i][j - 1]) + grid[i][j];
        }
      }
    }
    return board[row_cnt - 1][col_cnt - 1];
  }
};