<?php
class Solution
{

    /**
     * @param String[][] $grid
     * @return Integer
     */
    public function numIslands($grid)
    {
        $this->data = $grid;
        $this->row = count($grid);
        $this->col = count($grid[0]);
        // 是否已访问标识，快速判断
        $this->visited = array_map(function ($item) {
            return array_fill(0, $this->col, 0);
        }, range(0, $this->row-1));


        $counter = 0;
        for ($i=0; $i<$this->row; $i++) {
            for ($j=0;$j<$this->col; $j++) {
                if ($this->visited[$i][$j]) {
                    continue;
                }
                if ($this->data[$i][$j]) {
                    $counter++;
                    self::dfs($i, $j);
                }
            }
        }
        return $counter;
    }

    public function dfs($row, $col)
    {
        // printf("mark x:%s y:%s\n", $row, $col);
        // 确保坐标在范围内
        if ($row >=0 && $row <$this->row && $col>=0 && $col<$this->col
        && $this->data[$row][$col] && !$this->visited[$row][$col]) {
            $this->visited[$row][$col] = 1;
            self::dfs($row, $col-1);
            self::dfs($row, $col+1);
            self::dfs($row-1, $col);
            self::dfs($row+1, $col);
        }
    }

    public $data;
    public $visited;
    public $row;
    public $col;
}

$data = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]];
echo (new Solution)->numIslands($data);
