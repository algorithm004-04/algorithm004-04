<?php
class Solution {

    /**
     * @param Node $root
     * @return Integer[]
     */
    function postorder($root) {
        $arr = [];
        $this->helper($root, $arr);
        return $arr;
    }

    function helper($root, &$arr) {
        if($root) {
            foreach($root->children as $item) $this->helper($item, $arr);
            $arr[] = $root->val;
        }
    }
}