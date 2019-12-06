<?php

class Solution
{

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    public function plusOne($digits)
    {
        if (empty($digits)) {
            return [];
        }
        // 是否需要进1标识
        $flag = 0;
        
        for ($len=count($digits),$i=$len-1; $i>=0; $i--) {
            $tmp = $digits[$i] + $flag;
            if ($i == $len-1) {
                $tmp++;
            }
            
            if ($tmp == 10) {
                $flag = 1;
            } else {
                $flag = 0;
            }
            $digits[$i] = $tmp%10;
        }
        if ($flag) {
            array_unshift($digits, 1);
        }
        return $digits;
    }
}
