<?php

class Solution
{

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid)
    {
        foreach ($grid as $key => $value) {
            foreach ($value as $k => $v) {
                if ($key == 0 && $k == 0) continue;
                else if ($key == 0) $grid[$key][$k] = $grid[$key][$k - 1] + $grid[$key][$k];
                else if ($k == 0) $grid[$key][$k] = $grid[$key - 1][$k] + $grid[$key][$k];
                else $grid[$key][$k] = min($grid[$key - 1][$k], $grid[$key][$k - 1]) + $grid[$key][$k];
            }
        }

        return $grid[count($grid) - 1][count($grid[0]) - 1];
    }
}