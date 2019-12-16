class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> visit;
        TreeNode* cur = root;
        while(cur || !visit.empty()){
            if(cur){
                visit.push(cur);
                res.push_back(cur->val);
                cur = cur->left;
            }  else{
                cur = visit.top();
                visit.pop();
                cur = cur->right;
               
            }
        }
        return res;
    }
};                 //�ǵݹ�
class Solution {
public:
    vector<int> res;
    vector<int> preorderTraversal(TreeNode* root) {
        if(root){
            res.push_back(root->val);
        preorderTraversal(root->left);
        preorderTraversal(root->right);
        }
        return res;
    }
};                               //�ݹ� 
  
