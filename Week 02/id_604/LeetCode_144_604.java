//解法1 使用递归，先访问该节点，在访问左子树，最后访问右子树
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorder(root,res);
            return res;

    }

    private void preorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);

        if(root.left != null){
            preorder(root.left,res);
        }

        if(root.right != null){
            preorder(root.right,res);
        }

    }
}


//解法2 使用栈模拟递归实现(创建一个结构体，Command用于表示出栈入栈执行的动作，方便理解)
struct Command{
    string s;
    TreeNode* node;
    Command(string s, TreeNode* node):s(s), node(node){}
};

class Solution2 {
public:
    vector<int> preorderTraversal(TreeNode* root) {

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

                if(command.node->left){
                    stack.push(Command("go",command.node->left));
                }

                stack.push(Command("print",command.node));
            }
        }


        return res;
    }
};

