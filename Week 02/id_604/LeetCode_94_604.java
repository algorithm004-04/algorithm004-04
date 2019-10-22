//使用递归，先遍历左子树，在访问节点，在遍历右子树
class Solution {
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
