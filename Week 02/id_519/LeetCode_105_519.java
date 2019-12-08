package algorithm.chapter2.second;

import java.util.HashMap;
import java.util.Map;

/**
 * 【105. 从前序与中序遍历序列构造二叉树】根据一棵树的前序遍历与中序遍历构造二叉树。 注意: 你可以假设树中没有重复的元素。 例如，给出 前序遍历
 * preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7] 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 
 * @author chying
 *
 */
public class LeetCode_105_519 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 在preorder中确定节点位置，在inorder中确定左右子树节点范围
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return buildNode(0, 0, inorder.length - 1, preorder, inMap);
	}

	private TreeNode buildNode(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> inMap) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[preStart]);
		int inIndex = inMap.get(node.val);
		int numsLeft = inIndex - inStart;
		node.left = buildNode(preStart + 1, inStart, inIndex - 1, preorder, inMap);
		node.right = buildNode(preStart + numsLeft + 1, inIndex + 1, inEnd, preorder, inMap);
		return node;
	}

	public static void main(String[] args) {
		LeetCode_105_519 a = new LeetCode_105_519();
		int[] preorder = new int[] { 1, 2, 4, 8, 5, 3, 6, 7 };
		int[] inorder = new int[] { 8, 4, 2, 5, 1, 6, 3, 7 };
		a.buildTree(preorder, inorder);
	}
}
