package week_02.lesson6;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorder {

    static List<Integer> result = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        if (null != root.left) {
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if (null != root.right) {
            inorderTraversal(root.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode param = new TreeNode(1);
        param.left = null;
        param.right = new TreeNode(2);
        param.right.left = new TreeNode(3);
        param.right.right = new TreeNode(4);
        List<Integer> r = inorderTraversal(param);
        System.out.println(r.size());
        for (int i : r) {
            System.out.println(i);
        }
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}





























