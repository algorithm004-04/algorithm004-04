<?php
/**
 * 144. 二叉树的前序遍历
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $res = [];
        $this->helper($root,$res);
        return $res;
    }

    function helper($root,&$res){
        if($root == null) return;
        $res[] = $root->val;
        $this->helper($root->left,$res);
        $this->helper($root->right,$res);
    }
}