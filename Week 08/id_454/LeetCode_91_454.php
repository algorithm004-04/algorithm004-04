<?php
class Solution
{
    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s)
    {
        $n = strlen($s);
        if ($n == 0 || $s[0] == '0') return 0;
        if ($n == 1) return 1;
        $dp[0] = 1;
        $dp[1] = ($s[0] * 10 + $s[1] * 1 > 26) ? 1 : 2;
        $dp[1] = ($s[1] == '0') ? $dp[1] - 1 : $dp[1];
        for ($i = 2; $i < $n; $i++) {
            if ($s[$i] == 0) {
                if ($s[$i - 1] * 10 + $s[$i] > 26 || $s[$i - 1] == '0') return 0;
                else $dp[$i] = $dp[$i - 2];
            } else {
                $dp[$i] = ($s[$i - 1] * 10 + $s[$i] > 26 || $s[$i - 1] == '0') ? $dp[$i - 1] : $dp[$i - 1] + $dp[$i - 2];
            }
        }
        return $dp[$n - 1];
    }
}
