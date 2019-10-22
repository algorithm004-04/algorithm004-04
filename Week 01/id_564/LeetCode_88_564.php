<?php

class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    function merge(&$nums1, $m, $nums2, $n) {
        $i = $m - 1;
        $j = $n - 1; 
        $k = $m + $n - 1;
        while ($i >= 0 && $j >= 0) {
            if ($nums2[$j] > $nums1[$i]) {
                $nums1[$k--] = $nums2[$j--];
            } else {
                $nums1[$k--] = $nums1[$i--];
            }
        }
        while ($j >= 0) {
            $nums1[$k--] = $nums2[$j--];
        }
    }
}

?>


