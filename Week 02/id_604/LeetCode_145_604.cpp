//二叉树的后序遍历，使用递归模拟栈进行实现
struct Command{
    string s;
    TreeNode* node;
    Command(string s, TreeNode* node):s(s), node(node){}
};

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {

        vector<int> res;
        if(root == NULL){
            return res;
        }

        stack<Command> stack;
        stack.push(Command("go",root));


        while(!stack.empty()){
            Command command = stack.top();
            stack.pop();

            if(command.s == "print"){
                res.push_back(command.node->val);
            } else {

                stack.push(Command("print",command.node));

                if(command.node->right){
                    stack.push(Command("go",command.node->right));
                }

                if(command.node->left){
                    stack.push(Command("go",command.node->left));
                }


            }
        }


        return res;
    }
};
