<?php
/**
 * 283. 移动零
 * leetcode : https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 思路：
 * 变量J记录所有非0元素的位置，把0元素后移
 * Class Solution
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $j = 0;
        for($i=0;$i<count($nums);$i++){
            if($nums[$i] != 0){
                $temp = $nums[$j];
                $nums[$j] = $nums[$i];
                $nums[$i] = $temp;
                $j++;
            }
        }
        return $nums;
    }
}