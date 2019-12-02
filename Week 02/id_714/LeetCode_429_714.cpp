/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution
{
public:
  vector<vector<int>> levelOrder(Node *root)
  {
    vector<vector<int>> res;
    if (root == NULL)
    {
      return res;
    }
    queue<Node *> queue;
    queue.push(root);
    while (!queue.empty())
    {
      vector<int> temp;
      size_t size = queue.size();
      for (int i = 0; i < size; i++)
      {
        Node *node = queue.front();
        temp.push_back(node->val);
        queue.pop();
        for (int j = 0; j < node->children.size(); j++)
        {
          queue.push(node->children[j]);
        }
      }
      res.push_back(temp);
    }
    return res;
  }
};