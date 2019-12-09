<?php
class Solution
{

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    public function minPathSum($grid)
    {
        $row = count($grid);
        if ($row == 0) {
            return 0;
        }
        $col = count($grid[0]);
        for ($i=0;$i<$row;$i++) {
            for ($j=0; $j<$col;$j++) {
                if ($i == $j && $i == 0) {
                    continue;
                } elseif ($i == 0) {
                    $grid[$i][$j] = $grid[$i][$j-1] + $grid[$i][$j];
                } elseif ($j == 0) {
                    $grid[$i][$j] = $grid[$i-1][$j] + $grid[$i][$j];
                } else {
                    $grid[$i][$j] = min($grid[$i-1][$j], $grid[$i][$j-1]) + $grid[$i][$j];
                }
            }
        }
        return $grid[$row-1][$col-1];
    }
}

$s = [[1,3,1],[1,5,1],[4,2,1]];
echo (new Solution)->minPathSum($s);
