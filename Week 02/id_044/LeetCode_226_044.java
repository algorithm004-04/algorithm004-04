package week_02.lesson7;

public class InvertBinaryTree {


    public static TreeNode invertTree(TreeNode root) {

        if (null == root) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode secondLeft = new TreeNode(2);
        TreeNode secondRight = new TreeNode(7);
        root.left = secondLeft;
        root.right = secondRight;
        secondLeft.left = new TreeNode(1);
        secondLeft.right = new TreeNode(3);
        secondRight.left = new TreeNode(6);
        secondRight.right = new TreeNode(9);
        System.out.println(invertTree(root).right.val);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
