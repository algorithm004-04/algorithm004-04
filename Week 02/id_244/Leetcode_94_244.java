import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import javafx.beans.binding.IntegerBinding;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.35%)
 * Likes:    309
 * Dislikes: 0
 * Total Accepted:    70.1K
 * Total Submissions: 102.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rets = new ArrayList<>();
        helper(root, rets);
        return rets;
    }

    public void helper(TreeNode root, List<Integer> rets) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, rets);
            }
            rets.add(root.val);
            if (root.right != null) {
                helper(root.right, rets);
            }
        }
    }

}
// @lc code=end
