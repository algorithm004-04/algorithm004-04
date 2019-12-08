import java.util.HashMap;
import java.util.Map;

/*
236. 二叉树的最近公共祖先

“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”


*
*
 */
public class LeetCode_236_269 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        //在左子树中寻找公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //在右子树中寻找公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //左子树中没找到，返回右子树。右子树中也没找到，返回左子树
        return left == null ? right : right == null ? left : root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
