<?php
/*
 * @lc app=leetcode.cn id=66 lang=php
 *
 * [66] 加一
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        $length = count($digits);
        
        for ((int) $i = $length - 1; $i >= 0; $i --) 
        {
            if ($digits[$i] < 9) {
                $digits[$i] ++;
                return $digits;
            }

            $digits[$i] = 0;
        }   
        if ($digits[0] == 0) {
            array_unshift($digits, 1);
        }

        return $digits;
    }
}

$array = [99];
$obj = new Solution();
print_r($obj -> plusOne($array));
// @lc code=end

