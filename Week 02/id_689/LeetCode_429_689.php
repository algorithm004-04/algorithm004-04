<?php
class Solution {

    /**
     * @param Node $root
     * @return Integer[][]
     */
    function levelOrder($root) {
        $arr = [];
        $this->helper($root, 0, $arr);
        return $arr;
    }

    function helper($root, $depth, &$arr) {
        if($root) {
            $arr[$depth][] = $root->val;
            foreach($root->children as $item) $this->helper($item, $depth + 1, $arr);
        }
    }
}