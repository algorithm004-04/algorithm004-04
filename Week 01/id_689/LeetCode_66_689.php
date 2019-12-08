<?php
class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        $length = count($digits);
        for ($i = $length -1; $i >= 0; $i--) {
            $digits[$i] = ++$digits[$i] % 10;
            if ($digits[$i] != 0) return $digits;
        }

        array_unshift($digits, 1);
        return $digits;
    }
}