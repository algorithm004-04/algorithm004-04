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
    public function preorderTraversal($root)
    {
        if (!$root) {
            return [];
        }
        $res = [$root->val];
        if ($root->left) {
            $res = array_merge($res, self::preorderTraversal($root->left));
        }
        if ($root->right) {
            $res = array_merge($res, self::preorderTraversal($root->right));
        }
        return $res;
    }
}
