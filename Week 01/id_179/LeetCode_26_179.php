<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    public function removeDuplicates(&$nums)
    {
        $counter = 0;
        for ($i=0, $len=count($nums); $i<$len; $i++) {
            // initial
            if (!isset($cur)) {
                $cur = $nums[$i];
                $counter++;
            } else {
                if ($cur == $nums[$i]) {
                    // update for next new element
                    continue;
                } else {
                    // met new element
                    $nums[$counter] = $nums[$i];
                    $cur = $nums[$i];
                    $counter++;
                }
            }
        }
        return $counter;
    }
}
