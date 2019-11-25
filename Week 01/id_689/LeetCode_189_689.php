<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $length = count($nums);
        $k %= $length;
        $this->reverse($nums, 0, $length - 1);
        $this->reverse($nums, 0, $k - 1);
        $this->reverse($nums, $k, $length - 1);
        return $nums;
    }

    function reverse(&$nums, $star, $end) {
        while($star < $end) {
            $temp = $nums[$star];
            $nums[$star] = $nums[$end];
            $nums[$end] = $temp;
            $star++;
            $end--;
        }
    }
}