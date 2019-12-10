<?php

class Solution
{

    /**
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n)
    {
        if ($n <= 0) return 0;
        if ($n <= 2) return $n;

        $pos1 = 1;
        $pos2 = 2;
        for ($i = 3; $i <= $n; $i++) {
            $sum = $pos1 + $pos2;
            $pos1 = $pos2;
            $pos2 = $sum;
        }

        return $pos2;
    }
}

$solution = new Solution();
print_r($solution->climbStairs(44));