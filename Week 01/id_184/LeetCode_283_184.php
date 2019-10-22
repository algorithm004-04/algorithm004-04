<?php
/*
 * @lc app=leetcode.cn id=283 lang=php
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $length = count($nums);

        foreach($nums as $k => $v) {
            if ($v == 0) {
                array_push($nums, 0);
                unset($nums[$k]);
            }
        }
    }
}

$array = [2,1,0,5,0,6,4,0,9,0,8,0,7,0,11];

print_r(implode($array));

echo "\n";

$obj = new Solution();

$obj -> moveZeroes($array);

print_r(implode($array));

// @lc code=end

