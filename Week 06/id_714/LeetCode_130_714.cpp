class UnionFind
{
public:
  UnionFind(int size)
  {
    parent_ = new int[size];
    for (int i = 0; i < size; i++)
    {
      parent_[i] = i;
    }
  }
  ~UnionFind()
  {
    delete[] parent_;
    parent_ = nullptr;
  }
  void Union(int nums1, int nums2)
  {
    if (nums1 == nums2)
      return;
    int nums1_root = FindParent(nums1);
    int nums2_root = FindParent(nums2);
    if (nums1_root == nums2_root)
      return;
    parent_[nums1_root] = nums2_root;
  }
  bool IsConnected(int nums1, int nums2)
  {
    return FindParent(nums1) == FindParent(nums2);
  }

private:
  int *parent_ = nullptr;
  int FindParent(int num)
  {
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
  void solve(vector<vector<char>> &board)
  {
    if (board.size() == 0 || board[0].size() == 0)
      return;
    if (board.size() <= 2 || board[0].size() <= 2)
      return;
    int row = board.size();
    int col = board[0].size();
    UnionFind uf(row * col + 1);
    for (int i = 0; i < row; i++)
    {
      for (int j = 0; j < col; j++)
      {
        if (board[i][j] == 'O')
        {
          if (i == 0 || i == row - 1 || j == 0 || j == col - 1)
          {
            uf.Union(Node2Num(i, j, col), row * col);
          }
          else
          {
            if (i >= 1 && board[i - 1][j] == 'O')
              uf.Union(Node2Num(i, j, col), Node2Num(i - 1, j, col));
            if (i <= row - 1 && board[i + 1][j] == 'O')
              uf.Union(Node2Num(i, j, col), Node2Num(i + 1, j, col));
            if (j >= 1 && board[i][j - 1] == 'O')
              uf.Union(Node2Num(i, j, col), Node2Num(i, j - 1, col));
            if (j <= col - 1 && board[i][j + 1] == 'O')
              uf.Union(Node2Num(i, j, col), Node2Num(i, j + 1, col));
          }
        }
      }
    }

    for (int i = 0; i < row; i++)
    {
      for (int j = 0; j < col; j++)
      {
        if (board[i][j] == 'O')
        {
          if (!uf.IsConnected(Node2Num(i, j, col), row * col))
          {
            board[i][j] = 'X';
          }
        }
      }
    }
  }

  int Node2Num(int row, int col, int col_cnt)
  {
    return row * col_cnt + col;
  }
};