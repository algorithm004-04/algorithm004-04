<?php
class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function lengthOfLIS($nums)
    {
        if (count($nums) == 0) return 0;
        $dp = array_fill(0, count($nums), 1);
        for ($i = 0; $i < count($nums); $i++) {
            for ($j = 0; $j < $i; $j++) {
                if ($nums[$i] > $nums[$j])
                    $dp[$i] = max($dp[$i], $dp[$j] + 1);
            }
        }
        return max($dp);
    }
}
