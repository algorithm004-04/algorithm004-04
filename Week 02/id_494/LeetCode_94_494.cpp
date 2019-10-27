/*
 * @lc app=leetcode id=94 lang=cpp
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (58.96%)
 * Likes:    2077
 * Dislikes: 92
 * Total Accepted:    552.8K
 * Total Submissions: 935.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 *
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */

#include <stdio.h>
#include <vector>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
 public:
  /**
   * 非递归 - 使用栈来实现
   * 对中序遍历 - 左根右，
   * 1. 对任意一个子树，如果左子树不为空则不断的讲左子树根节点入栈;
   * 2. 遇到空，说明当前子树没有左子树了，将节点值存入结果;
   * 3. 访问当前子树的右子树，不为空，压入栈，继续从1开始，为空，说明当前子树访问完成，弹出节点
   * 4. 不断重复1-3，直到栈为空
   * note: 使用vector模拟栈
   */
  vector<int> inorderTraversal(TreeNode *root) {
    if (root == nullptr) {
      return {};
    }
    vector<int> result;
    vector<TreeNode *> s;
    s.push_back(root);
    while (!s.empty()) {
      // 不断的将左子树根节点入栈
      while (root->left != nullptr) {
        s.push_back(root->left);
        root = root->left;
      }
      // 左子树遍历完，出栈，访问弹出节点的值
      do {
        root = s.back();
        s.pop_back();
        result.push_back(root->val);
        if (root->right != nullptr) {
          // 节点右子树不为空，入栈，挑出，按第一个while逻辑访问右子树
          s.push_back(root->right);
          root = root->right;
          break;
        }
      } while(!s.empty());
    }

    return result;
  }

  // 递归 - 深度优先
  vector<int> inorderTraversal2(TreeNode *root) {
    if (root == nullptr) {
      return {};
    }
    vector<int> result;
    inorderTraversal3(root, result);
    return result;
  }

  void inorderTraversal3(TreeNode *root, vector<int> &result) {
    if (root != nullptr) {
      inorderTraversal3(root->left, result);
      result.push_back(root->val);
      inorderTraversal3(root->right, result);
    }
  }

  void inorderTraversal2(TreeNode *root, vector<int> &result) {
    if (root == nullptr) {
      return;
    }
    if (root->left != nullptr) {
      inorderTraversal2(root->left, result);
    }
    result.push_back(root->val);
    if (root->right != nullptr) {
      inorderTraversal2(root->right, result);
    }
  }
};
// @lc code=end

#include <iostream>

int main() {
  TreeNode *root = new TreeNode(2);
  root->left = new TreeNode(3);
  root->left->left = new TreeNode(1);

  vector<TreeNode *> nodes;
  nodes.push_back(root);
  nodes.push_back(root->left);
  nodes.push_back(root->left->left);

  auto result = Solution().inorderTraversal(root);
  for (auto &e : result) {
    std::cout << e << " ";
  }
  std::cout << "\n";

  for (auto iter = nodes.rbegin(); iter != nodes.rend(); iter++) {
    delete *iter;
  }

  return 0;
}
