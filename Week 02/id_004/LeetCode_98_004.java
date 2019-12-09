import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int maxValue = Integer.MAX_VALUE;
    private int minValue = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return this.helper(root, null, null);

    }

    private boolean helper(TreeNode root, Integer minValue, Integer maxValue) {

        if (root == null)
            return true;

        if (minValue != null && root.val <= minValue) return false;
        if (maxValue != null && root.val >= maxValue) return false;

        return this.helper(root.left, minValue, root.val) && this.helper(root.right, root.val, maxValue);
    }
}