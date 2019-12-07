class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> visit;
        vector<int> res;
        TreeNode* cur = root;
        while(cur || !visit.empty()){
            if(cur){
                visit.push(cur);
                cur = cur->left;
            } else{
                cur = visit.top();
                visit.pop();
                res.push_back(cur->val);
                cur = cur->right;
            }
        }
        return res;
    }
};               //�ǵݹ�
class Solution {
public:
    vector<int> res;
    vector<int> inorderTraversal(TreeNode* root) {
        if(root){
          inorderTraversal(root->left);
          res.push_back(root->val);
          inorderTraversal(root->right);  
        }
        return res;
    }
};           //�ݹ� 
