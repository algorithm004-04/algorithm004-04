<?php
class Solution {

    /**
     * @param Node $root
     * @return Integer[]
     */
    function preorder($root) {
        $arr = [];
        $this->helper($root, $arr);
        return $arr;
    }

    function helper($root, &$arr) {
        if($root) {
            $arr[] = $root->val;
            foreach($root->children as $item) $this->helper($item, $arr);
        }
    }
}