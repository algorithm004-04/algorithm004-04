<?php


class Solution
{

    /**
     * @param Integer $n
     * @return String[][]
     */
    public function solveNQueens($n)
    {
        self::walk(0, $n);
        return self::read($this->res);
    }

    public $res = [];
    public $flag = [];
    public $cur = [];

    public function walk($lev, $max)
    {
        // $lev 当前层
        if ($lev == $max) {
            $this->res[] = $this->cur;
            return;
        }

        for ($col = 0; $col < $max; $col++) {
            if (self::ok($lev, $col, $max)) {
                $this->cur[$lev] = $col;
                self::walk($lev + 1, $max);
            }
        }
    }

    public function ok($row, $col, $max)
    {
        $leftUp = $col - 1;
        $rightUp = $col + 1;
        for ($i = $row - 1; $i >= 0; $i--) {
            if ($leftUp >= 0 && $this->cur[$i] == $leftUp) {
                return false;
            }

            if ($rightUp < $max && $this->cur[$i] == $rightUp) {
                return false;
            }

            if ($this->cur[$i] == $col) {
                return false;
            }

            $leftUp--;
            $rightUp++;
        }
        return true;
    }

    public function read($res)
    {
        return array_map(function ($item) {
            $len = count($item);
            return array_map(function ($_item) use ($len) {
                $res = '';
                for ($i = 0; $i < $len; $i++) {
                    if ($i == $_item) {
                        $res .= 'Q';
                    } else {
                        $res .= '.';
                    }
                }
                return $res;
            }, $item);
        }, $res);
    }
}


$n = 4;
$s = new Solution();
print_r($s->solveNQueens($n));
