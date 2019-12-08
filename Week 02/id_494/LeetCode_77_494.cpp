/*
 * @lc app=leetcode id=77 lang=cpp
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (50.28%)
 * Likes:    981
 * Dislikes: 57
 * Total Accepted:    234.9K
 * Total Submissions: 466.2K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 *
 * Example:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 *
 *
 */

#include <iostream>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
  /**
   * 广度优先 - 暴力法，遍历所有情况，k对应树的深度
   * 例如：n:4 k:2
   * 第一层 可以选1 2 3
   * 第二层 对应1可选 2 3 4，对应2 可选3 4，对应3 可选4
   */

  // dfs标准
  vector<vector<int>> combine(int n, int k) {
    vector<int> path;
    vector<vector<int>> results;
    dfs(results, path, 0, k, n);  // * 从剩余的数中选合适的数

    return results;
  }

  // 按直觉写出
  vector<vector<int>> combine1(int n, int k) {
    if (n == 1) {
      return vector<vector<int>>{{1}};
    }
    vector<vector<int>> results;
    if (n == k) {
      results.emplace_back(vector<int>{});
      for (int i = 0; i < n; i++) {
        results.back().push_back(i + 1);
      }
      return results;
    }

    for (int i = 0; i < n - k + 1; i++) {
      vector<int> result;
      result.reserve(k);
      result.push_back(i + 1);
      dfs(results, result, i + 1, k, n);
      result.pop_back();
    }

    return results;
  }

  // path可以是引用
  void dfs(vector<vector<int>>& results, vector<int>& path, int i, int k,
           int n) {
    // terminator
    if (path.size() == k) {
      results.emplace_back(path);
      return;
    }
    // for (int j = i; j < n; j++) { // 未剪枝
    for (int j = i; j < min(n, n - k + 1 + i); j++) {  //* 剪枝
      // process
      path.push_back(j + 1);  // 选数放到集合中
      // drill down
      dfs(results, path, j + 1, k, n);  // 选下一个数
      // reverse state
      path.pop_back();  // !回溯
    }
    return;
  }
};

int main() {
  std::cout << "==> 4, 2\n";
  Solution().combine(4, 2);
  std::cout << "==> 5, 3\n";
  Solution().combine(5, 3);
  return 0;
}
