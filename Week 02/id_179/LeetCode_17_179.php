<?php
/**
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
class Solution
{
    public $_phone = [
        2 => ['a', 'b', 'c'],
        3 => ['d', 'e', 'f'],
        4 => ['g', 'h', 'i'],
        5 => ['j', 'k', 'l'],
        6 => ['m', 'n', 'o'],
        7 => ['p', 'q', 'r', 's'],
        8 => ['t', 'u', 'v'],
        9 => ['w', 'x', 'y', 'z'],
    ];
    public $res = [];
    /**
     * @param String $digits
     * @return String[]
     */
    public function letterCombinations($digits)
    {
        self::gen($digits);
        return $this->res;
    }

    public function gen($d)
    {
        if ($d == '') {
            return;
        }
        $first = substr($d, 0, 1);
        if (isset($this->_phone[$first])) {
            $_tmp = [];
            if ($this->res) {
                foreach ($this->res as $res) {
                    foreach ($this->_phone[$first] as $v) {
                        $_tmp[] = $res.$v;
                    }
                }
            } else {
                foreach ($this->_phone[$first] as $v) {
                    $_tmp[] = $v;
                }
            }
            $this->res = $_tmp;
        }
        self::gen(substr($d, 1));
    }
}

// $data = 23;
// print_r((new Solution)->letterCombinations($data));
