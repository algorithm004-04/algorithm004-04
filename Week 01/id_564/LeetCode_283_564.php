<?php
class Solution {
    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $j = 0;
        for ($i = 0; $i < count($nums); $i++) {
            if ($nums[$i] != 0) {
                $nums[$j] = $nums[$i];
                if ($i != $j) {
                    $nums[$i] = 0;
                }
                $j ++;
            }
        }
    }

    function moveZeroes1(&$nums) {
        $count = 0;
        for($i = 0; $i < count($nums); $i ++) {
            if ($nums[$i] == 0) {
                $count ++;
            } else {
                $nums[$i-$count] = $nums[$i];
            }
        }
        for ($i = count($nums) - $count; $i < count($nums); $i++) {
            $nums[$i] =0;
        }
    }
}