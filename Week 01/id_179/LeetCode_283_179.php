<?php

class Solution
{
    /**
     * @param Integer[] $nums
     * @return NULL
     */
    public function moveZeroes(&$nums)
    {
        for ($i = 0, $j = 0, $len = count($nums); $i < $len; $i++) {
            if ($nums[$i] != 0) {
                $nums[$j++] = $nums[$i];
            }
        }
        for (;$j<$len;$j++) {
            $nums[$j] = 0;
        }
    }
}
