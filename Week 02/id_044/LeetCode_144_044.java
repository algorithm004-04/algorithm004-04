package week_02.lesson6;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorder {

    static List<Integer> result = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {

        if (null == root) {
            return new ArrayList<>(0);
        }

        result.add(root.val);
        if (null != root.left) {
            preorderTraversal(root.left);
        }
        if (null != root.right) {
            preorderTraversal(root.right);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode param = new TreeNode(1);
        param.left = null;
        param.right = new TreeNode(2);
        param.right.left = new TreeNode(3);
        List<Integer> r = preorderTraversal(param);
        System.out.println(r.size());
        for (int i : r) {
            System.out.println(i);
        }
    }

}
