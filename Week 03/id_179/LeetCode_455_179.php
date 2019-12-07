<?php

class Solution
{
    /**
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    public function findContentChildren($g, $s)
    {
        sort($g);
        sort($s);
        $lg = count($g);
        $ls = count($s);
        
        $i = 0;
        $j = 0;
        while ($i < $lg && $j <$ls) {
            if ($g[$i] <= $s[$j]) {
                $i++;
            }
            $j++;
        }
        return $i;
    }
}

// 排序后遍历，能满足的就分配，不能满足的就往后跳至满足为止
