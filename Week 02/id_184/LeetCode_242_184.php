<?php
/*
 * @lc app=leetcode.cn id=242 lang=php
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {

        if ($s ===  $t) {
            return true;
        }

        $sArr = str_split($s);
        $tArr = str_split($t);
        sort($sArr);
        sort($tArr);

        $s = implode("", $sArr);
        $t = implode("", $tArr);

        if ($s === $t) {
            return true;
        } else {
            return false;
        }
    }

    function isAnagram2($s, $t)
    {
        if (strlen($s) != strlen($t)) {
            return false;
        }

        $counter = array();

        for ($i = 0; $i < strlen($s); $i ++) {
            if (!$counter[$s[$i]]) {
                $counter[$s[$i]] = 0;
            }

            if (!$counter[$t[$i]]) {
                $counter[$t[$i]] = 0;
            }

            $counter[$s[$i]] ++;
            $counter[$t[$i]] --;
        }

        foreach ($counter as $item) {
            if ($item) {
                return false;
            }
        }

        return true;
    }
}

$obj = new Solution();

$t = 'animal';
$s = 'inalma';

$obj -> isAnagram2($s, $t);


// @lc code=end

