<?php

/**
 * Class Solution
 * 思路：两个循环。内部循环将数组向右移动一个位子，移动完后将原数组最后一个值赋第一个位子。
 * https://leetcode-cn.com/problems/rotate-array/
 * 189. 旋转数组
 */
class Solution
{
    public function rotate($nums, $k)
    {
        while ($k > 0) {
            $temp = $nums[count($nums) - 1];
            for ($i = count($nums) - 1;
                 $i > 0;
                 $i--) {
                $nums[$i] = $nums[$i - 1];
            }

            $nums[0] = $temp;
            $k--;
        }

    }
}