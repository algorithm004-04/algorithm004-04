//使用递归，先访问该节点，在访问左子树，最后访问右子树
class Solution {
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
