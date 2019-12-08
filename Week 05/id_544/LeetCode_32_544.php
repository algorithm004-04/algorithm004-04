<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s) {
        $maxl = 0;
        $stack = [-1];
        for($i=0;$i<strlen($s);$i++){
            if($s[$i]=='('){
                array_push($stack,$i);
            }else{
                array_pop($stack);
                if(empty($stack)){
                    array_push($stack,$i);
                }else{
                    $maxl = max($maxl,$i-end($stack));
                }
            }
        }
        return $maxl;
    }
}
