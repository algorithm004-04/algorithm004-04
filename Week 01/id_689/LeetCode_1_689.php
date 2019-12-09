<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $length = count($nums);
        $use_nums = [];
        for ($i = 0; $i < $length; $i++) {
            $search = $target  - $nums[$i];
            if (isset($use_nums[$search])) {
                return [$use_nums[$search], $i];
            }

            $use_nums[$nums[$i]] = $i;
        }

        return [];
    }
}