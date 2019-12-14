<?php
/*
 * @lc app=leetcode.cn id=144 lang=php
 *
 * [144] 二叉树的前序遍历
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
    function preorderTraversal($root) {
        $list = $stack = [];

        while($root != null || !empty($stack)) {
            array_push($list, $root -> val);

            if ($root -> right != null) {
                array_unshift($stack, $root -> right);
            }

            $root = $root -> left;
            if ($root == null && !empty($stack)) {
                $root = array_shift($stack);
            }
        }

        return $list;
    }
}
// @lc code=end

