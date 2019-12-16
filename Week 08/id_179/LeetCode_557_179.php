<?php
class Solution
{

    /**
     * @param String $s
     * @return String
     */
    public function reverseWords($s)
    {
        if ($s == '') {
            return $s;
        }
        $_e = explode(' ', $s);
        foreach ($_e as $k=>$v) {
            $_e[$k] = strrev($v);
        }
        return implode(' ', $_e);
    }
}

$str = "Let's take LeetCode contest";
$s= new Solution();
echo $s->reverseWords($str);
