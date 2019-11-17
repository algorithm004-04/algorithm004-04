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
  // 左-根-右
public:
  vector<int> inorderTraversal(TreeNode *root)
  {
    vector<int> res;
    // innerInorderTraversal(root, res);

    // 1
    // stack<TreeNode*> node_stack;
    // TreeNode* curr_node;
    // curr_node = root;
    // while(curr_node != NULL || !node_stack.empty()){
    //     while(curr_node != NULL){
    //         node_stack.push(curr_node);
    //         curr_node = curr_node->left;
    //     }
    //     curr_node = node_stack.top();
    //     node_stack.pop();
    //     res.push_back(curr_node->val);
    //     curr_node = curr_node->right;
    // }

    // 2. 莫里斯解法
    TreeNode *curr_node = root;
    TreeNode *prev_node;
    while (curr_node != NULL)
    {
      if (curr_node->left == NULL)
      {
        // 左结点是空，输出当前结点
        res.push_back(curr_node->val);
        curr_node = curr_node->right;
      }
      else
      {
        // 左结点不为空的时候，去左子树找当前结点的前驱节点
        prev_node = curr_node->left;
        while (prev_node->right != NULL && prev_node->right != curr_node)
        {
          prev_node = prev_node->right;
        }

        if (prev_node->right == NULL)
        {
          // 前驱节点的右结点如果是NULL，表示当前节点还没有添加到前驱节点的右结点里
          prev_node->right = curr_node;
          curr_node = curr_node->left;
        }
        else
        {
          // 前驱节点的右结点已经是当前结点了，需要输出当前结点，然后把前驱结点的右结点恢复原状，当前结点更新为当前结点的右结点
          prev_node->right = NULL;
          res.push_back(curr_node->val);
          curr_node = curr_node->right;
        }
      }
    }

    return res;
  }

private:
  void innerInorderTraversal(TreeNode *root, vector<int> &res)
  {
    if (root == NULL)
    {
      return;
    }
    innerInorderTraversal(root->left, res);
    res.push_back(root->val);
    innerInorderTraversal(root->right, res);
  }
};