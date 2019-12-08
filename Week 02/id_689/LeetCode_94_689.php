<?php
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal($root) {
        $arr = [];
        $this->helper($root, $arr);
        return $arr;
    }

    function helper($root, &$arr) {
        if ($root) {
            if ($root->left) $this->helper($root->left, $arr);
            $arr[] = $root->val;
            if ($root->right) $this->helper($root->right, $arr);
        }
    }
}