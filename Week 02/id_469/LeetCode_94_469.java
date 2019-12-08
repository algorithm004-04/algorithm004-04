import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历 中序遍历（LDR）
 * 
 * 是二叉树遍历的一种，也叫做中根遍历、中序周游。
 * 
 * 在二叉树中， 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
 * 
 * 遍历方法先左子树，后根结点，最后右子树
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}

// @lc code=end

