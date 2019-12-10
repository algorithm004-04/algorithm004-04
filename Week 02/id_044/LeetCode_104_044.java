package week_02.lesson7;

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }

    public static void main(String[] args) {

    }

}
