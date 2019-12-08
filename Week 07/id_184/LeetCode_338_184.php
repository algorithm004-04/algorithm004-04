<?php

class Solution {

    /**
     * @param Integer $num
     * @return Integer[]
     */
    function countBits($num) {
        $res[] = 0;
        for ($i = 1; $i <= $num; $i++) {
            $res[$i] = $res[(int)$i / 2] + $i % 2;
        }
        return $res;
    }
}