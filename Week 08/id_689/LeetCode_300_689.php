<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function lengthOfLIS($nums)
    {
        $length = count($nums);
        if ($length == 0) return 0;

        $dp[0] = 1;
        $max_ans = 1;
        for ($i = 1; $i < $length; $i++) {
            $max_val = 0;
            for ($j = 0; $j < $i; $j++) {
                if ($nums[$i] > $nums[$j]) {
                    $max_val = max($dp[$j], $max_val);
                }
            }

            $dp[$i] = $max_val + 1;
            $max_ans = max($dp[$i], $max_ans);
        }

        return $max_ans;
    }
}
