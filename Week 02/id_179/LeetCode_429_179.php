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
    protected $res = [];
    /**
     * @param Node $root
     * @return Integer[][]
     */
    public function levelOrder($root)
    {
        if (!$root) {
            return [];
        }
        $this->res = [$root];
        while ($this->res) {
            $_res = [];
            foreach ($this->res as $_node) {
                $res = array_merge([$root->val], self::fetchChildren($_node));
                $_res[] = $_node;
            }
            $this->res = $_res;
        }
        return $res;
    }
    
    public function fetchChildren($root)
    {
        $res = [];
        foreach ($root->children as $child) {
            $res[] = $child->val;
        }
        return $res;
    }
}
