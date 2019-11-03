<?php
/*
 * @lc app=leetcode.cn id=88 lang=php
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    // function merge(&$nums1, $m, $nums2, $n) {
        
    // }

    // 方法 二
    function merge(&$nums1, $m, $nums2, $n) {
        $nums1 = array_slice($nums1, 0, $m);
        $nums1 = array_merge($nums1, $nums2);
        sort($nums1);
    }
}
// @lc code=end

