<?php
class Solution
{

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    public function canJump($nums)
    {
        if (empty($nums)) {
            return false;
        }
        return self::jump($nums);
    }

    public function jump($nums)
    {
        $len  = count($nums);
        $max = 0;
        for ($i = 0; $i < $len; $i++) {
            // 当前位置和前一位最大能到的距离比较
            if ($i > $max) {
                return false;
            }
            $max = max($max, $nums[$i] + $i);
        }
        return true;
    }
}
