<?php
/*
 * @lc app=leetcode.cn id=49 lang=php
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        if (!$strs) {
            return array();
        }

        $data = array();

        foreach ($strs as $item) {
            $keyStr = str_split($item);
            sort($keyStr);
            $key = implode('', $keyStr);

            $data[$key][] = $item;
        }

        return $data;
    }
}

$obj = new Solution();

$strs = ["eat", "tea", "tan", "ate", "nat", "bat"];

$obj -> groupAnagrams($strs);
// @lc code=end

