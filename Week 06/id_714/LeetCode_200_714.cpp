class UnionFind
{
public:
  UnionFind(vector<vector<char>> &grid)
  {
    row_cnt_ = grid.size();
    col_cnt_ = grid[0].size();
    parent_ = new int[row_cnt_ * col_cnt_];
    for (int i = 0; i < row_cnt_; i++)
    {
      for (int j = 0; j < col_cnt_; j++)
      {
        if (grid[i][j] == '1')
        {
          parent_[i * col_cnt_ + j] = i * col_cnt_ + j;
          count_++;
        }
        else
        {
          parent_[i * col_cnt_ + j] = 0;
        }
      }
    }
  }
  ~UnionFind()
  {
    delete[] parent_;
    parent_ = nullptr;
  }
  void Union(int nums1_row, int nums1_col, int nums2_row, int nums2_col)
  {
    if (nums1_row == nums2_row && nums1_col == nums2_col)
      return;
    int nums1_root = FindParent(nums1_row, nums1_col);
    int nums2_root = FindParent(nums2_row, nums2_col);
    if (nums1_root == nums2_root)
      return;
    parent_[nums1_root] = nums2_root;
    count_--;
  }
  int count() { return count_; }

private:
  int *parent_ = nullptr;
  int count_ = 0;
  int row_cnt_ = 0;
  int col_cnt_ = 0;
  int FindParent(int row, int col)
  {
    int num = row * col_cnt_ + col;
    while (num != parent_[num])
    {
      parent_[num] = parent_[parent_[num]];
      num = parent_[num];
    }
    return num;
  }
};

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

    // 3. union find
    UnionFind uf(grid);
    for (int r = 0; r < row; r++)
    {
      for (int c = 0; c < col; c++)
      {
        if (grid[r][c] == '1')
        {
          grid[r][c] = '0';
          if (r - 1 >= 0 && grid[r - 1][c] == '1')
            uf.Union(r, c, r - 1, c);
          if (r + 1 < row && grid[r + 1][c] == '1')
            uf.Union(r, c, r + 1, c);
          if (c - 1 >= 0 && grid[r][c - 1] == '1')
            uf.Union(r, c, r, c - 1);
          if (c + 1 < col && grid[r][c + 1] == '1')
            uf.Union(r, c, r, c + 1);
        }
      }
    }

    return uf.count();

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