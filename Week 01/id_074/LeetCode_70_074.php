<?php


class Solution {

    /**
     * o(n)
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {

        if($n<=2){
            return $n;
        }

        $f1 = 1;
        $f2 = 2;
        $f3 = 3;
        
        
        for($i = 3; $i<$n+1; $i++) {

            $f3 = ($f1+$f2);
            $f1 = $f2;
            $f2 = $f3;

        }

        return $f3;
        
    
    
    }

}

