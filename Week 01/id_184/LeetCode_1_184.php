<?php
/*
 * @lc app=leetcode.cn id=1 lang=php
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $length = count($nums);
        if ($length < 1) {
            return [];
        }

        for ((int) $i = 0; $i <= $length - 1; $i ++) {
            $num1 = $nums[$i];
            for ((int) $j = $i + 1; $j <= $length - 1; $j ++) {
                $num2 = $nums[$j];

                if (($num1 + $num2) == $target) {
                    $result = array();
                    $result[] = $i;
                    $result[] = $j;

                    return $result;
                }
            }
        }
    }
}

$array  = [1,2,4,5,6,7,8,9];
$target = 11;

$obj = new Solution();
print_r($obj -> twoSum($array, $target));
// @lc code=end

