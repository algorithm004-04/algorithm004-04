<?php

class Solution
{
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    public function twoSum($nums, $target)
    {
        $b = $nums;
        $need = [];
        foreach ($b as $k => $v) {
            $needVal = $target - $v;
            if (isset($need[$needVal])) {
                return [$need[$needVal], $k];
            }
            $need[$v] = $k;
        }
        return [];
    }
}
