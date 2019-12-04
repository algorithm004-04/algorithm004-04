<?php

class Solution
{
    /**
     * @param Integer[] $nums
     * @return Integer
     */
    public function findMin($nums)
    {
        $len = count($nums);
        $left=0;
        $end=$len-1;
        while ($left<$end) {
            $mid = intval(($left+$end)/2);
            
            if ($nums[$end] < $nums[$mid]) {
                $left = $mid + 1;
            } else {
                $end = $mid;
            }
        }
        return $nums[$left];
    }
}
