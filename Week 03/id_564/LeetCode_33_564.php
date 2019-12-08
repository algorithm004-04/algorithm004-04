<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        if (!$nums) return -1;
        $low = 0;
        $high = count($nums) - 1;

        while ($low <= $high) {
            $mid = $low + floor(($high - $low) / 2);
            if ($target == $nums[$mid]) return $mid;
            if ($nums[$low] <= $nums[$mid]) {
                if ($nums[$low] <= $target && $target < $nums[$mid]) {
                    $high = $mid - 1;
                } else {
                    $low = $mid + 1;
                }
            } else {
                if ($nums[$mid] < $target && $target <= $nums[$high]) {
                    $low = $mid + 1;
                } else {
                    $high = $mid - 1;
                }
            }
        }
        return -1;
    }
}
?>