<?php
class Solution
{

    /**
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    public function searchMatrix($matrix, $target)
    {
        $m = count($matrix);
        $n = count($matrix[0]);

        $start = 0;
        $end = $m*$n-1;
        // 因为数组有序，因此可以拼接当作一个数组
        for (;$start<=$end;) {
            $mid = $start + (($end-$start) >> 1);
            $x = floor($mid/$n);
            $y = $mid %  $n;
            
            if ($matrix[$x][$y]  == $target) {
                return true;
            }

            if ($matrix[$x][$y]  > $target) {
                $end = $mid - 1;
            } else {
                $start = $mid + 1;
            }
        }
        return false;
    }
}
