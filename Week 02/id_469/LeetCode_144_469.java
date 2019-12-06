import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 * 
 * 前序遍历（DLR），是二叉树遍历的一种，
 * 
 * 也叫做先根遍历、先序遍历、前序周游，可记做根左右。
 * 
 * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。
 * 
 * 
 * [144] 二叉树的前序遍历:先遍历根结点，再左结点，再右结点
 */

// @lc code=start
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
// @lc code=end

