<?php

class Solution {



    function merge(&$nums1, $m, $nums2, $n) {
        $p1 = $m - 1;
        $p2 = $n - 1;
        $p = $m + $n - 1;
        while($p1 >=0 && $p2 >= 0) {
            $nums1[$p--] = $nums1[$p1]>$nums2[$p2]?$nums1[$p1--]:$nums2[$p2--];
        }
            
        while($p1 < 0 && $p2 >= 0) {
            $nums1[$p--] = $nums2[$p2--];
        }
            
    }



}

