/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
  vector<int> preorderTraversal(TreeNode *root)
  {
    vector<int> res;

    // 根-左-右

    // 栈迭代
    TreeNode *curr_node = root;
    stack<TreeNode *> node_stack;
    while (curr_node != NULL || !node_stack.empty())
    {
      if (curr_node != NULL)
      {
        res.push_back(curr_node->val);
        if (curr_node->right != NULL)
        {
          node_stack.push(curr_node->right);
        }
        curr_node = curr_node->left;
      }
      else
      {
        curr_node = node_stack.top();
        node_stack.pop();
      }
    }

    return res;
  }
};