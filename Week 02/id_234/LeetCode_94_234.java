package week_02;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.tools.corba.se.idl.toJavaPortable.Helper;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_234 {
  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  public static void helper(TreeNode root, List<Integer> res) {
    if (root == null) return;
    if (root.left != null) helper(root.left, res);
    res.add(root.val);
    if (root.right != null) helper(root.right, res);
  }
}
