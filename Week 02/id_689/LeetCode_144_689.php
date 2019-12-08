<?php
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $arr = [];
        $this->helper($root, $arr);
        return $arr;
    }

    function helper($root, &$arr) {
        if ($root != null) {
            $arr[] = $root->val;
            if ($root->left != null) {
                $this->helper($root->left, $arr);
            }
            if ($root->right != null) {
                $this->helper($root->right, $arr);
            }
        }
    }
}