<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
        if ($nums == null || count($nums) == 0) return false;
        
        $n = count($nums);
        $max = 0;
        for ($i = 0; $i < $n; ++$i) {
            if ($max >= $n - 1) return true;
            if ($i > $max) return false;
            $max = max ($max, $i + $nums[$i]);
        }
        return false;
    }
}
?>