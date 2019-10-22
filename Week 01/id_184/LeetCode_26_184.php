<?php
/*
 * @lc app=leetcode.cn id=26 lang=php
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $length = count($nums);

        for ((int) $i = 1; $i <= ($length - 1); $i ++) {
            if ($nums[$i - 1] == $nums[$i]) {
                unset($nums[$i-1]);
                //$i ++;
            }
        }
    }
}

$array = [1,2,3,3,3,4,4,5,6,7,7,8,9,9];

print_r(implode('-', $array));
echo "\n";

$obj = new Solution();
$obj -> removeDuplicates($array);

print_r(implode('-', $array));

// @lc code=end

