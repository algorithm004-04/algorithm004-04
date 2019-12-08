<?php
class Solution {

    public $val = [];
    function preorder($root) {
        if ($root == null) {
            return $this->val;
        }
        
        $this->val[] = $root->val;
        foreach($root->children as $child){
            $this->preorder($child);
        }
        return $this->val;
    }
}
?>