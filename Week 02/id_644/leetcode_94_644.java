package com.company;
/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class indorderTraversal {
    public static void main(String[] args) {

    }

     public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList< >();
        midtravse(root,res);
        return res;
     }

     //递归
      public static void midtravse_recr(TreeNode root, List<Integer> res) {
        if(root != null) {
            if (root.left != null) {
                midtravse(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                midtravse(root.right, res);
            }
        }
      }
    // stack 模拟
    public static List<Integer> midtravse(TreeNode root, List<Integer> result) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    //莫里斯？



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
    }
}