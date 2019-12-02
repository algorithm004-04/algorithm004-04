<?php
/**
 * 94. 二叉树的中序遍历
 */
/**
 * 中序遍历
 * 左子树---> 根节点 ---> 右子树
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