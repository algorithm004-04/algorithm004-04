/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.70%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    35.9K
 * Total Submissions: 78.5K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
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
 * 
 * 
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
 * 
 */

// @lc code=start
/*
** floodfill + DFS
**
*/
class Solution {
public:
  // 左，右，上，下
  vector<int> dx{-1, 1, 0, 0};
  vector<int> dy{0, 0, -1, 1};
  vector<vector<char>> g;

  int numIslands(vector<vector<char>>& grid) {
    int islands = 0;
    g = grid;
    for (int i = 0; i < g.size(); ++i) {
      for (int j = 0; j < g[i].size(); ++j) {
        if (g[i][j] == '1')
          islands += sink(i, j);
      }
    }

    return islands;
  }

  int sink(int i, int j) {
    // trminator
    if (g[i][j] == '0') {
      return 0;
    }

    // process
    g[i][j] = '0';
    for (int k = 0; k < dx.size(); ++k) {
      int x = i + dx[k], y = j + dy[k];
      if (x >= 0 && x < g.size() && y >= 0 && y < g[i].size()) {
        if (g[x][y] == '1')
          sink(x, y);
      }
    }
    return 1;
  }
};

/*
** floodfill + BFS
*/
class Solution {
public:
  // 左，右，上，下
  vector<int> dx{-1, 1, 0, 0};
  vector<int> dy{0, 0, -1, 1};
  void mark_(vector<vector<char>>& g, int i, int j, queue<pair<int, int>> &q) {
    for (int k = 0; k < dx.size(); ++k) {
      int x = i + dx[k], y = j + dy[k];
      if (x >= 0 && x < g.size() && y >= 0 && y < g[i].size()) {
        if (g[x][y] == '1') {
          q.push({x, y});
          g[x][y] = '0';
        }
      }
    }
  }
  int numIslands(vector<vector<char>>& grid) {
    if (grid.size() == 0)
      return 0;
    int islands = 0;
    for (int i = 0; i < grid.size(); ++i) {
      for (int j = 0; j < grid[i].size(); ++j) {
        if (grid[i][j] == '1') {
          grid[i][j] = '0';
          islands++;
          queue<pair<int, int>> q;
          mark_(grid, i, j, q);
          while(!q.empty()) {
            auto it = q.front();
            int x = it.first, y = it.second;
            q.pop();
            grid[x][y] = '0';
            mark_(grid, x, y, q);
          }
        }
      }
    }

    return islands;
  }
};

/*
** union find
*/
class UnionFind {
public:
  UnionFind(vector<vector<char>> &grid) {
    m_ = grid.size();  
    n_ = grid[0].size();  
    father_ = new int[m_ * n_];
    count_ = 0;
    for (int i = 0; i < m_; ++i) {  
      for (int j = 0; j < n_; ++j) {  
        if (grid[i][j] == '1') {
          int id = i * n_ + j;
          father_[id] = id;
          count_++;
        }
      }  
    }  
  }
  int find (int node) {  
    if (father_[node] == node) {  
      return node;
    }
    father_[node] = find(father_[node]);  
    return father_[node];
  }
  void makeunion(int node1, int node2) {
    int find1 = find(node1);
    int find2 = find(node2);
    if(find1 != find2) {
      father_[find1] = find2;
      count_--;
    }
  }
  int getCount() {
    return count_;
  }
private:
  int *father_;  
  int m_, n_;
  int count_ ;
};

class Solution {
public:
  // 左，右，上，下
  vector<vector<int>> distance = {{1,0},{-1,0},{0,1},{0,-1}};
  int numIslands(vector<vector<char>>& grid) {
    if (grid.size() == 0 || grid[0].size() == 0)  {
        return 0;  
    }
    UnionFind uf(grid);  
    int rows = grid.size();  
    int cols = grid[0].size();  
    for (int i = 0; i < rows; ++i) {  
      for (int j = 0; j < cols; ++j) {  
        if (grid[i][j] == '1') {  
          for (auto d : distance) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
              int id1 = i*cols+j;
              int id2 = x*cols+y;
              uf.makeunion(id1, id2);  
            }  
          }  
        }  
      }  
    }  
    return uf.getCount(); 
  }
};

// @lc code=end

