package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = recursive_stack(root, res);
        return res;
    }
    // 递归算法
    public static List<Integer> recursive_rec(TreeNode root, List<Integer> res) {
        if(root != null) {
            res.add(root.val);
            if(root.left != null)
                recursive_rec(root.left,res);
            if(root.right != null)
                recursive_rec(root.right,res);
        }
        return res;
    }
    //模拟栈
    public static List<Integer> recursive_stack(TreeNode root,List<Integer> res) {
        Stack <TreeNode> stack = new Stack<>();
        if(root ==null)
            return res;
        stack.push(root);
        TreeNode cur  =root;
        while(stack.isEmpty() ) {
            cur = stack.pop();
            res.add(cur.val);

            if (cur.right != null)
                stack.push(cur.right);

            if (cur.left != null)
                stack.push(cur.left);


        }
        return res;
        }



    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}

