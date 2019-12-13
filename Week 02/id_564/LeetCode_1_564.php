<?php
class Solution {

    function twoSum($nums, $target) {

        $map = [];
        for ($i = 0; $i < count($nums)-1; $i++) {
            $needNum = $target- $nums[$i];

            if (isset($map[$needNum])) {
                return [$map[$needNum], $i];
            }

            $map[$nums[$i]] = $i;
        }
        return [0, 0];
    }

    function twoSum1($nums, $target) {
        for ($i = 0; $i < count($nums); $i ++) {
            for ($j = $i + 1; $j < count($nums); $j ++) {
                if ($nums[$i] + $nums[$j] == $target) {
                    return [$i, $j];
                }
            }
        }
    }

    function twoSum2($nums, $target) {
        foreach ($nums as $key => $value) {
            if (in_array(($target - $value), $nums)) {
                return [$key, array_search(($target - $value), $nums)];
            }
        }
    }

    function twoSum3($nums, $target) {
        $map = [];
        foreach ($nums as $key => $value) {
            if (array_key_exists($target - $value, $map)) {
                return [$key, $map[$target - $value]];
            }
            $map[$value] = $key;
        }
    }
}
?>