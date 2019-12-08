class UnionFind
{
public:
  UnionFind(int size)
  {
    count_ = size;
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

  void Union(int num1, int num2)
  {
    if (num1 == num2)
      return;
    int num1_root = parent(num1);
    int num2_root = parent(num2);
    if (num1_root == num2_root)
      return;
    parent_[num1_root] = num2_root;
    count_--;
  }

  int count() { return count_; }

private:
  int count_ = 0;
  int *parent_ = nullptr;

  int parent(int num)
  {
    while (num != parent_[num])
    {
      // 顺便压缩路径
      parent_[num] = parent_[parent_[num]];
      num = parent_[num];
    }
    return num;
  }
};

class Solution
{
public:
  int findCircleNum(vector<vector<int>> &M)
  {
    if (M.size() == 0 || M[0].size() == 0)
      return 0;
    UnionFind uf(M.size());
    for (int i = 0; i < M.size(); i++)
    {
      for (int j = i; j < M.size(); j++)
      {
        if (M[i][j] == 1)
        {
          uf.Union(i, j);
        }
      }
    }
    return uf.count();
  }
};