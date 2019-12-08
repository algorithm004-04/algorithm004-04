//解放1：使用递归，先遍历左子树，在访问节点，在遍历右子树
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){

        if(root == null){
            return;
        }

        if(root.left != null){
            inorder(root.left,res);
        }

        res.add(root.val);

        if(root.right != null){
            inorder(root.right,res);
        }

    }
}


//解法2：使用栈模拟递归
struct Command{
    string s;
    TreeNode* node;
    Command(string s, TreeNode* node):s(s), node(node){}
};

class Solution2 {
public:
    vector<int> inorderTraversal(TreeNode* root) {

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
                if(command.node->right){
                    stack.push(Command("go",command.node->right));
                }

                stack.push(Command("print",command.node));

                if(command.node->left){
                    stack.push(Command("go",command.node->left));
                }


            }
        }


        return res;
    }
};
