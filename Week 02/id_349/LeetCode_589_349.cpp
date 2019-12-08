/*
 * @lc app=leetcode.cn id=589 lang=cpp
 *
 * [589] N叉树的前序遍�?
 */

// @lc code=start
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
class Solution {
private: 
    void find(Node* root, vector<int>& output) {
        if (root == nullptr) {
            return;
        }
        output.push_back(root -> val);
        for (Node* child : root -> children) {
            find(child, output);
        }
    }
public:
    vector<int> preorder(Node* root) {
       vector<int> output;
       find(root, output);
       return output;
    }
};
// @lc code=end

