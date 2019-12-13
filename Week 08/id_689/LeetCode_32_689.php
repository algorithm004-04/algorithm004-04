<?php

class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s)
    {
        $max_ans = 0;
        $length = strlen($s);
        $dp = array_fill(0, $length, 0);

        for ($i = 1; $i < $length; $i++) {
            if ($s[$i] == ')') {
                if ($s[$i - 1] == '(') {
                    $dp[$i] = ($i >= 2 ? $dp[$i - 2] : 0) + 2;
                } else if ($s[$i - 1] == ')' && $i - $dp[$i - 1] > 0 && $s[$i - $dp[$i - 1] - 1] == '(') {
                    $dp[$i] = $dp[$i - 1] + (($i - $dp[$i - 1]) >= 2 ? $dp[$i - $dp[$i - 1] - 2] : 0) + 2;
                }

                $max_ans = max($max_ans, $dp[$i]);
            }
        }

        return $max_ans;
    }
}