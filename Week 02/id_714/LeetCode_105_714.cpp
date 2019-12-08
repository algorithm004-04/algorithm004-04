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
  TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
  {
    if (preorder.size() == 0 || inorder.size() == 0)
    {
      return NULL;
    }
    return innerBuildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
  }

private:
  TreeNode *innerBuildTree(vector<int> &preorder,
                           int preorder_left,
                           int preorder_right,
                           vector<int> &inorder,
                           int inorder_left,
                           int inorder_right)
  {
    if (preorder_left > preorder_right)
    {
      return NULL;
    }

    int root_val = preorder[preorder_left];
    int f = 0;
    for (int i = inorder_left; i <= inorder_right; i++)
    {
      if (inorder[i] == root_val)
      {
        f = i;
        break;
      }
    }
    TreeNode *root = new TreeNode(root_val);
    int dis = f - inorder_left; // 左子树的元素数量

    root->left = innerBuildTree(preorder, preorder_left + 1, preorder_left + dis, inorder, inorder_left, f - 1);
    root->right = innerBuildTree(preorder, preorder_left + dis + 1, preorder_right, inorder, f + 1, inorder_right);

    return root;
  }
};