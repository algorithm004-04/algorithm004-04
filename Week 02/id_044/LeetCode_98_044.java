package week_02.lesson7;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (null == root) {
            return true;
        }
        int val = root.val;
        if (null != lower && lower >= val) {
            return false;
        }
        if (null != upper && upper <= val) {
            return false;
        }
        if (!helper(root.right, val, upper)) {
            return false;
        }
        if (!helper(root.left, lower, val)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(2);
        TreeNode secondLeft = new TreeNode(1);
        TreeNode secondRight = new TreeNode(3);*/
        TreeNode root = new TreeNode(5);
        TreeNode secondLeft = new TreeNode(1);
        TreeNode secondRight = new TreeNode(4);
        root.left = secondLeft;
        root.right = secondRight;
        secondLeft.left = new TreeNode(3);
        secondRight.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }
}
