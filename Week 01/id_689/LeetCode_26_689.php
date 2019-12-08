<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $length = count($nums);
        for ($l = 0, $i= 1; $i < $length; $i++) {
            if ($nums[$l] != $nums[$i]) {
                $nums[++$l] = $nums[$i];
            }
        }

        return $l + 1;
    }
}