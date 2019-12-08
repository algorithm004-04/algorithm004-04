<?php
/*
 * @lc app=leetcode.cn id=94 lang=php
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal($root) {
        $list = array();
        $stack = array();

        while($root != null || !empty($stack)) {
            while($root != null) {
                array_unshift($stack, $root);
                $root = $root -> left;
            }
            $root = array_shift($stack);
            array_push($list, $root -> val);
            $root = $root -> right;
        }

        return $list;
    }
}
// @lc code=end

/**
 * public List<Integer> inorderTraversal(TreeNode root) {
 *   List<Integer> list = new ArrayList<Integer>();

 *   Stack<TreeNode> stack = new Stack<TreeNode>();
 *   TreeNode cur = root;

 *   while(cur!=null || !stack.empty()){
 *       while(cur!=null){
 *           stack.add(cur);
 *           cur = cur.left;
 *       }
 *       cur = stack.pop();
 *       list.add(cur.val);
 *       cur = cur.right;
 *   }

 *   return list;
 *}
 **/