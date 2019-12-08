package week_02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_234 {
  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  public static void helper(TreeNode root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    if (root.left != null) helper(root.left, res);
    if (root.right != null) helper(root.right, res);
  }
}
