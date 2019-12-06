import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (61.79%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    45.9K
 * Total Submissions: 73.8K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
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
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
}


//非递归
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null ) return res;

        Stack<TreeNode> st = new Stack<TreeNode>();       
        st.push(root);
        TreeNode  p;
        while ((p = st.pop()) != null) {
            res.add(p.val);
            if (p.right != null) st.push(p.right);
            if (p.left != null) st.push(p.left);   
        }
        return res;


    }
}

//递归
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        _preorderTraversal(root);
        return res;
        
    }

    private void _preorderTraversal(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        _preorderTraversal(root.left);
        _preorderTraversal(root.right);
    }
}
// @lc code=end

