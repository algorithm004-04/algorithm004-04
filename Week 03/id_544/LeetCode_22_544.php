<?php

/**
 * Class Solution
 * 22. 括号生成
 */
class Solution {

    /**
     * @param Integer $n
     * @return String[]
     */
    public function generateParenthesis($n)
    {
        $list = [];
        $this->doadd($n, $n, $list, "");
        return $list;
    }

    public function doadd($left, $right, &$list, $path)
    {

        if ($left == 0 && $right == 0) {
            $list[] = $path;
            return;
        }
        if ($left != 0)
            $this->doadd($left - 1, $right, $list, $path . "(");
        if ($right != 0 && $right > $left)
            $this->doadd($left, $right - 1, $list, $path . ")");
    }
}