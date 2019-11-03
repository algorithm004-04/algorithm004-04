

/**
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 */
public class LeetCode_111_029 {
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if ((root.left == null) && (root.right == null)) {
			return 1;
		}

		int min_depth = Integer.MAX_VALUE;
		if (root.left != null) {
			min_depth = Math.min(minDepth(root.left), min_depth);
		}
		if (root.right != null) {
			min_depth = Math.min(minDepth(root.right), min_depth);
		}

		return min_depth + 1;
	}

//	class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//		TreeNode(int x) {
//			val = x;
//		}
//	}
}
