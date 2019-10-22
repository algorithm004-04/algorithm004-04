<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $length = count($nums);
        for ($i = 0, $j = 0; $i < $length; $i++) {
            if ($nums[$i] != 0) {
                $temp = $nums[$j];
                $nums[$j++] = $nums[$i];
                $nums[$i] = $temp;
            }
        }

        return $nums;
    }
}