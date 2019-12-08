<?php
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        if ($prices == null || count($prices) == 0) return 0;
        
        $profit = 0;
        for ($i = 1; $i < count($prices); $i++) {
            if ($prices[$i] > $prices[$i - 1]) {
                $profit += ($prices[$i] - $prices[$i - 1]);
            }
        }
        return $profit;
    }
}
?>