<?php

class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        if($digits[count($digits) - 1] == 9) { // 判断最后一个数组是否为9
            for ($j = count($digits) - 1; $j >= 0; $j--) { // 循环数组直到不是9的数组出现
                if($digits[$j] < 9) {
                    $digits[$j] += 1; // 将此并返回
                    return $digits;
                } elseif($digits[$j] == 9) {
                    $digits[$j] = 0;
                    if($j == 0) { // 如果第一位数字是9, 在数组头位插入 1
                        array_unshift($digits, 1);
                        return $digits;
                    }
                }
            }
        } else {
            $digits[count($digits) - 1] += 1;
        }
        return $digits;
    }
}

