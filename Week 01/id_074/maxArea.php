<?php

class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {

        $r = count($height)-1;
        $l = 0;
        $areas = [];

        for ($i = $r; $i > 0; --$i) {
            
            $area = min($height[$l], $height[$r]) * $i;
            $areas[] = $area;

            if ($height[$r] > $height[$l]) {
                ++$l;
            } else {
                --$r;
            }
            
        }

        return max($areas);
    }
}