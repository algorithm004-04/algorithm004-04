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
        $maps = array();
        foreach ($nums as $k => $value) {
            $maps[$value] = $k;
        }

        foreach ($nums as $k => $item) {
            $temp = $target - $item;
            if (isset($maps[$temp])) {
                if ($k !== $maps[$temp]) {
                    $result = [];
                    $result[] = $k;
                    $result[] = $maps[$temp];

                    return $result;
                }
            }
        }

        return [0, 0];
    }
}
// @lc code=end

$obj = new Solution();

$nums = [1,2,3,5,6,8,4,2,99,111];
$target = 112;

print_r($obj -> twoSum($nums, $target));