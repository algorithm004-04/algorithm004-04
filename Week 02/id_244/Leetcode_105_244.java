import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (61.94%)
 * Likes:    262
 * Dislikes: 0
 * Total Accepted:    28.1K
 * Total Submissions: 45.1K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int preIdx = 0;
    int[] preorder;
    int[] inorder;

    HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();

    private TreeNode helper(int inLeft, int inRight) {

        if (inLeft == inRight) {
            return null;
        }
        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        preIdx++;

        int index = idxMap.get(rootVal);
        root.left = helper(inLeft, index);
        root.right = helper(index + 1, inRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return helper(0, inorder.length);
    }
}
// @lc code=end
