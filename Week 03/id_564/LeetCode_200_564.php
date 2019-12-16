<?php
class Solution {
    private $grid;
    private $num = 0;
    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
        if (empty($grid) || count($grid) <= 0 || count($grid[0]) <= 0) {
            return 0;
        }
        $this->grid = $grid;
        
        foreach ($this->grid as $key => $value) {
            foreach ($value as $k => $item) {
                if ($this->grid[$key][$k] == 1) {
                    $this->num++;
                    $this->dfs($key, $k);
                }
            }
        }
        return $this->num;
    }
    
    function dfs($key, $k) {
        if (!isset($this->grid[$key][$k]) || $this->grid[$key][$k] != 1) {
            return;
        }
        $this->grid[$key][$k] = 0;
        $this->dfs($key + 1, $k);
        $this->dfs($key - 1, $k);
        $this->dfs($key, $k + 1);
        $this->dfs($key, $k - 1);
    }
}
?>