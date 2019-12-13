<?php

class Solution
{

    /**
     * @param Integer $x
     * @return Integer
     */
    function mySqrt($x)
    {
        $left = 0;
        $right = 999999;
        while ($left < $right) {
            $mid = ($left + $right + 1) >> 1;
            $square = $mid * $mid;
            $square > $x ? $right = $mid - 1 : $left = $mid;
        }
        return $left;
    }
}