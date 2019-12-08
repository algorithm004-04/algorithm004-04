<?php

class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s)
    {
        $length = strlen($s);
        if ($length == 0) return 0;

        $dp[$length] = 1;
        $dp[$length - 1] = $s[$length - 1] == '0' ? 0 : 1;
        for ($i = $length - 2; $i >= 0; $i--) {
            if ($s[$i] == '0') {
                $dp[$i] = 0;
                continue;
            }

            if (($s[$i] - '0') * 10 + ($s[$i + 1] - '0') <= 26) {
                $dp[$i] = $dp[$i + 1] + $dp[$i + 2];
            } else {
                $dp[$i] = $dp[$i + 1];
            }
        }

        return $dp[0];
    }
}