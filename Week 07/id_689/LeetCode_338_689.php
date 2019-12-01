<?php

class Solution
{

    /**
     * @param Integer $num
     * @return Integer[]
     */
    function countBits($num)
    {
        $result = [];
        $result[0] = 0;
        for ($i = 1; $i <= $num; $i++) {
            if ($i % 2 == 1) {
                $result[$i] = $result[$i - 1] + 1;
            } else {
                $result[$i] = $result[$i / 2];
            }
        }
        return $result;
    }
}
