<?php

class Solution
{

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid)
    {
        $depth = count($grid);
        $len = count($grid[0]);
        $dp = $grid;
        for ($i = 1; $i < $depth; $i++) $dp[$i][0] += $dp[$i - 1][0];
        for ($i = 1; $i < $len; $i++) $dp[0][$i] += $dp[0][$i - 1];
        for ($i = 1; $i < $depth; $i++) {
            for ($j = 1; $j < $len; $j++) {
                $dp[$i][$j] = min($dp[$i - 1][$j], $dp[$i][$j - 1]) + $grid[$i][$j];
            }
        }
        return $dp[$depth - 1][$len - 1];
    }
}
