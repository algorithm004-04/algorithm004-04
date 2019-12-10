<?php
/*
// Definition for a Node.
class Node {
    public $val;
    public $children;

    @param Integer $val
    @param list<Node> $children
    function __construct($val, $children) {
        $this->val = $val;
        $this->children = $children;
    }
}
*/
class Solution
{

    /**
     * @param Node $root
     * @return Integer[]
     */
    public function postorder($root)
    {
        if (!$root) {
            return [];
        }
        $res = [];
        foreach ($root->children as $child) {
            $res = array_merge($res, self::postorder($child));
        }
        return array_merge($res, [$root->val]);
    }
}
