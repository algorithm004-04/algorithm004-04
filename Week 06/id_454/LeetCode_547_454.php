<?php


class Solution
{
    /**
     * @param Integer[][] $M
     * @return Integer
     */
    function findCircleNum($M)
    {

        $visited = [];

        foreach ($M as $key1 => $item1) {
            foreach ($item1 as $key2 => $item2) {
                $visited[$key1][$key2] = 0;
            }
        }

        $count = 0;

        for ($i = 0; $i < count($M); $i++) {
            for ($j = 0; $j < count($M[0]); $j++) {
                if ($visited[$i][$j] === 0 && $M[$i][$j] == 1) {
                    $this->visitFriends($M, $visited, $i, $j);
                    $count++;
                }
            }
        }

        return $count;
    }


    function visitFriends(&$M, &$visited, $m, $n)
    {
        if ($m < 0 || $m > count($M) || $n < 0 || $n > count($M)) {
            return;
        }

        $visited[$m][$n] = 1;
        $visited[$n][$m] = 1;

        for ($i = 0; $i < count($M[0]); $i++) {
            if ($M[$n][$i] == 1 && $visited[$n][$i] == 0) {
                $this->visitFriends($M, $visited, $n, $i);
            }
        }
    }
}
