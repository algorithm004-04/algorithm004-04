<?php
class Solution {

    function rotate(&$nums, $k) {
        $temp = 0; 
        $previous = 0;
        for ($i = 0; $i < $k; $i++) {
            $previous = $nums[count($nums) - 1];
            for ($j = 0; $j < count($nums); $j++) {
                $temp = $nums[$j];
                $nums[$j] = $previous;
                $previous = $temp;
            }
        }
    }

    function rotate1(&$nums, $k) {
        for ($i = 0; $i < count($nums); $i++) {
            $a[($i+$k) % count($nums)] = $nums[$i];
        }
        for ($i = 0; $i < count($nums); $i++) {
            $nums[$i] = $a[$i];
        }
    }
}

?>


