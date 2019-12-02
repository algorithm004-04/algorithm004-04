<?php
class Solution
{
    /**
     * @param Integer[][] $M
     * @return Integer
     */

    public $parent = [];

    function find($i)
    {
        if ($this->parent[$i] == -1) {
            return $i;
        }

        return $this->find($this->parent[$i]);
    }

    function union($i, $j)
    {
        $i_root = $this->find($i);
        $j_root = $this->find($j);
        if ($i_root != $j_root) {
            $this->parent[$i_root] = $j_root;
        }
    }

    function findCircleNum($M)
    {
        for ($i = 0, $length = count($M); $i < $length; $i++) {
            $this->parent[$i] = -1;
        }

        for ($i = 0; $i < $length; $i++) {
            for ($j = 0; $j < $length; $j++) {
                if ($M[$i][$j] == 1 && $i != $j) {
                    $this->union($i, $j);
                }
            }
        }

        $count = 0;
        for ($i = 0; $i < $length; $i++){
            if ($this->parent[$i] == -1) {
                $count++;
            }
        }

        return $count;
    }
}
