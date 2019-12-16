package week_02;

public class LeetCode_236_234 {
  private TreeNode ans;

  public LeetCode_236_234() {
    this.ans = null;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    this.recurseTree(root, p, q);
    return this.ans;
  }
  // 递归 T:O(n) S:O(n)
  private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
    if (currentNode == null) return false;
    int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
    int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
    int mid = ((currentNode == p) || (currentNode == q)) ? 1 : 0;

    if (mid + left + right >= 2) {
      this.ans = currentNode;
    }
    return (mid + left + right) > 0;
  }
}
