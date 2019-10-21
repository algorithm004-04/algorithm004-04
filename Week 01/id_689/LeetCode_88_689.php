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
        $p1 = $m - 1;
        $p2 = $n - 1;
        $p = $m + $n - 1;
        while (($p1 >= 0) && ($p2 >= 0)) $nums1[$p--] = $nums1[$p1] > $nums2[$p2] ? $nums1[$p1--] : $nums2[$p2--];
        while ($p2 >= 0) $nums1[$p--] = $nums2[$p2--];
        return $nums1;
    }
}