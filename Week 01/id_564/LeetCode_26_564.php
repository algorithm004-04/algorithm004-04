<?php
class Solution {

    function removeDuplicates(&$nums) {
        if (count($nums) == 0) {
            return 0;
        }

        $p = 0;
        $q = 1;
        $len = count($nums);
        while($q < $len) {
            if ($nums[$p] != $nums[$q]) {
                if ($q - $p > 1) {
                    $nums[$p + 1] = $nums[$q];
                }
                $p++;
            }
            $q++;
        }
        return $p + 1;
    }

    function removeDuplicates2(&$nums) {
        if (count($nums) == 0) {
            return 0;
        }

        $j = 0;
        $len = count($nums);
        for($i = 0; $i < $len; $i++) {
            if ($nums[$i] != $nums[$j]) {
                $j++;
                $nums[$j] = $nums[$i];
            }
        }

        return $j + 1;
    }
}
?>