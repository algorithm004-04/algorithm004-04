<?php


class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $k = fmod($k,count($nums));
        $this->reverse($nums, 0, count($nums)-1);
        $this->reverse($nums, 0, $k-1);
        $this->reverse($nums, $k, count($nums)-1);
    }
    
    function reverse(&$nums, $start, $end){
        while($start < $end){
            $tmp = $nums[$start];
            $nums[$start] = $nums[$end];
            $nums[$end] = $tmp;
            $start++;
            $end--;
        }
    }
}
