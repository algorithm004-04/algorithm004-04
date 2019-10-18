<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    public function rotate(&$nums, $k)
    {
        while ($k-- > 0) {
            array_unshift($nums, array_pop($nums));
        }
    }
}
