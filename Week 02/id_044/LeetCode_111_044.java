package week_02.lesson7;

public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (null != root.left) {
            min = Math.min(minDepth(root.left),min);
        }
        if (null != root.right) {
            min = Math.min(minDepth(root.right),min);
        }

        return min + 1;
    }

    public static void main(String[] args) {

    }

}
