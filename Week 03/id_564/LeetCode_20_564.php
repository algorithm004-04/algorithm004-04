<?php
class Solution {

    /**
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    function searchMatrix($matrix, $target) {
        if (count($matrix) == 0) return false;
        $m = count($matrix);
        $n = count($matrix[0]);

        $low = 0;
        $high = $m * $n - 1;
        while ($low <= $high) {
            $mid = $low + floor(($high - $low) / 2);
            if ($matrix[floor($mid / $n)][$mid % $n] == $target) {
                return true;
            } else if ($matrix[floor($mid / $n)][$mid % $n] < $target) {
                $low = $mid + 1;
            } else {
                $high = $mid - 1;
            }
        } 
        return false;
    }
}
?>