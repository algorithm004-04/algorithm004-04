
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

        // 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    private  TreeNode ans;

    public  Solution() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root,p, q);
        return this.ans;
    }

    private  boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        int left = this.recurseTree(currentNode.left,p,q)?1:0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            this.ans = currentNode;
        }
        return (left + right + mid > 0);
    }
}