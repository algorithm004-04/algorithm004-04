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
    vector<int> res;
public:
    vector<int> postorder(Node* root) {
        if(root){
            for(auto node:root->children){
                postorder(node);
            }
            res.push_back(root->val);
        }
        return res;
    }
/*
    vector<int> postorder(Node* root) {
        vector<int> res;
        if(root){
            list<Node*> stack;
            stack.push_back(root);
            while(!stack.empty()){
                Node *treeNode = stack.back();
                stack.pop_back();

                for(Node *node : treeNode->children){
                    stack.push_back(node);
                }
                res.push_back(treeNode->val);
            }
            reverse(res.begin(),res.end());
        }
        return res;
    }
// */
};