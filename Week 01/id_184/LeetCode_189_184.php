<?php
/*
 * @lc app=leetcode.cn id=189 lang=php
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $length = count($nums);

        for ((int) $i = 0; $i < $k; $i ++) {
            $swap = $nums[$length - 1];
            unset($nums[$length - 1]);
            array_unshift($nums, $swap);
        }
    }
}

//$array = [-1,99,5,6,7,4,6,3,4];
$array = [1,2,3,4,5,6,7];
$k     = 3;

print_r(implode("-", $array));
echo "\n";
$obj = new Solution();
$obj -> rotate($array, $k);
print_r(implode("-", $array));
// @lc code=end

