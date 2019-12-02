<?php

class Solution
{

    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix)
    {
        $rows = count($matrix);
        $cols = $rows > 0 ? count($matrix[0]) : 0;
        $dp = [];
        $maxSqLen = 0;
        for ($i = 1; $i <= $rows; $i++) {
            for ($j = 1; $j <= $cols; $j++) {
                if ($matrix[$i - 1][$j - 1] == '1') {
                    $dp[$i][$j] = min(min($dp[$i][$j - 1], $dp[$i - 1][$j]), $dp[$i - 1][$j - 1]) + 1;
                    $maxSqLen = max($maxSqLen, $dp[$i][$j]);
                }
            }
        }

        return $maxSqLen * $maxSqLen;
    }
}