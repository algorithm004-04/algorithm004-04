<?php

class Solution
{

    /**
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    public function merge(&$nums1, $m, $nums2, $n)
    {
        $nums1 = array_merge(array_slice($nums1, 0, $m), $nums2);
        sort($nums1);
        $nums1 = array_slice($nums1, 0, $m+$n);
    }
}
