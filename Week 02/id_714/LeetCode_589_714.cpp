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
  vector<int> preorder(Node *root)
  {
    vector<int> res;
    if (root == NULL)
    {
      return res;
    }
    stack<Node *> node_stack;
    node_stack.push(root);
    Node *curr_node;
    while (!node_stack.empty())
    {
      curr_node = node_stack.top();
      res.push_back(curr_node->val);
      node_stack.pop();
      for (int i = curr_node->children.size() - 1; i >= 0; i--)
      {
        node_stack.push(curr_node->children[i]);
      }
    }
    return res;
  }
};