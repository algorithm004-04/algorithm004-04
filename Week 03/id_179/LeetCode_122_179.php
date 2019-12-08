<?php
class Solution
{
    /**
     * @param Integer[] $prices
     * @return Integer
     */
    public function maxProfit($prices)
    {
        $profit = 0;
        for ($i=0,$len=count($prices)-1;$i<=$len-1;$i++) {
            // 后一天比今天贵，那就今天买，明天出😂
            if ($prices[$i] < $prices[$i+1]) {
                $profit += $prices[$i+1] -  $prices[$i];
            }
        }
        return $profit;
    }
}
