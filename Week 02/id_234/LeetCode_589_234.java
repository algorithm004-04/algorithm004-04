package week_02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_234 {
  public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(Node root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    if (!root.children.isEmpty()) {
      for (Node node : root.children) {
        helper(node, res);
      }
    }
  }
}
