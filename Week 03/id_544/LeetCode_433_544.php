<?php

/**
 * Class Solution
 * 433. 最小基因变化
 */
class Solution {

    /**
     * @param String $start
     * @param String $end
     * @param String[] $bank
     * @return Integer
     */
    function minMutation($start, $end, $bank) {
        $que = [];
        $vis = [];
        $que[] = $start;
        $ans = 0;
        while (!empty($que)) {
            $ans++;
            $n = count($que);
            for ($i = 0; $i < $n; $i++) {
                $tmp = current($que);
                array_pop($que);
                for ($j = 0; $j < count($bank); $j++) {
                    if ($vis[$j] == 0) {
                        $diff = 0;
                        for ($k = 0; $k < 8; $k++) {
                            if ($tmp[$k] != $bank[$j][$k]) $diff++;
                        }
                        if ($diff == 1) {
                            if ($bank[$j] == $end) return $ans;
                            $vis[$j] = 1;
                            array_push($que, $bank[$j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
}