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
class NodeStatus
{
public:
  Node *node;
  int status = 0; // 0 haven't pushed children to stack
                  // 1 have pushed children to stack

  NodeStatus() {}
  NodeStatus(Node *_node, int _status)
  {
    node = _node;
    status = _status;
  }
};
class Solution
{
public:
  vector<int> postorder(Node *root)
  {
    // 子结点-根
    // vector<int> res;
    // if(root == NULL){
    //     return res;
    // }
    // stack<NodeStatus> node_stack;
    // Node* cur;
    // NodeStatus ns(root,0);
    // node_stack.push(ns);
    // while(!node_stack.empty()){
    //     if(node_stack.top().status == 0){
    //         node_stack.top().status = 1;
    //         cur = node_stack.top().node;
    //         // 需要把子结点压到栈里
    //         for(int i = cur->children.size() - 1; i >= 0; i--){
    //             NodeStatus temp_ns(cur->children[i],0);
    //             node_stack.push(temp_ns);
    //         }
    //     }else{
    //         // 已经添加过子结点到栈里的结点，需要出栈了
    //         res.push_back(node_stack.top().node->val);
    //         node_stack.pop();
    //     }
    // }

    // 后序是前序的倒序，先按前序的排一遍，然后反转
    // 前序：根-子
    // 后序：子-根
    vector<int> res;
    if (root == NULL)
      return res;
    stack<Node *> node_stack;
    node_stack.push(root);
    while (!node_stack.empty())
    {
      Node *node = node_stack.top();
      node_stack.pop();
      for (int i = 0; i < node->children.size(); i++)
      {
        node_stack.push(node->children[i]);
      }
      res.push_back(node->val);
    }
    reverse(res.begin(), res.end());
    return res;
  }
};