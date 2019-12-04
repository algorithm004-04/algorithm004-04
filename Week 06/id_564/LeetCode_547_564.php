<?php
class Solution {

    /**
     * @param Integer[][] $M
     * @return Integer
     */
    function findCircleNum($M) {
        $visited = [];
        $count = 0;
        for ($i = 0; $i < count($M); $i++) {
            if ($visited[$i] == 0) {
                $this->dfs($M, $visited, $i);
                $count++;
            }
        }
        return $count;
    }

    function dfs($m, &$visited, $i) {
        for ($j = 0; $j < count($m); $j++) {
            if ($m[$i][$j] == 1 && $visited[$j] == 0) {
                $visited[$j] = 1;
                $this->dfs($m, $visited, $j);
            }
        }
    }
}
?>