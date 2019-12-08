<?php
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    public $res = [];
    function inorderTraversal($root) {
        if ($root) {
            $this->inorderTraversal($root->left);
            array_push($this->res, $root->val);
            $this->inorderTraversal($root->right);
        }
        return $this->res;
    }
}
?>