package alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaoyang on 2019-10-27.
 */
class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
      while(cur!=null){
        stack.add(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      cur = cur.right;
    }

    return list;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

}
