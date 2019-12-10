<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function threeSum($nums)
    {
        $result = [];
        $length = count($nums);
        if (!$nums || $nums < 3) return $result;
        sort($nums);
        for ($current = 0; $current < $length; $current++) {
            if ($nums[$current] > 0) break;
            if ($current > 0 && $nums[$current] == $nums[$current - 1]) continue;
            $left = $current + 1;
            $right = $length - 1;
            while ($left < $right) {
                $sum = $nums[$current] + $nums[$left] + $nums[$right];
                if ($sum == 0) {
                    $result[] = [$nums[$current], $nums[$left], $nums[$right]];
                    while ($left < $right && $nums[$left] == $nums[$left + 1]) $left++;
                    while ($left < $right && $nums[$right] == $nums[$right - 1]) $right--;
                    $left++;
                    $right--;
                } elseif ($sum > 0) $right--;
                elseif ($sum < 0) $left++;
            }
        }

        return $result;
    }
}

$solution = new Solution();
$nums = [-1, 0, 1, 2, -1, -4];
print_r($solution->threeSum($nums));