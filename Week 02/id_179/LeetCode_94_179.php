<?php
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution
{

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    public function inorderTraversal($root)
    {
        if (!$root) {
            return [];
        }
        $res = [];
        if ($root->left) {
            $res = array_merge(self::inorderTraversal($root->left), $res);
        }
        $res = array_merge($res, [$root->val]);
        if ($root->right) {
            $res = array_merge($res, self::inorderTraversal($root->right));
        }
        return $res;
    }
}
