<?php
class Solution
{
    function validPalindrome($s)
    {
        $count = strlen($s);
        for ($l = 0, $r = $count - 1; $l < $count; $l++, $r--) {
            if ($s[$l] != $s[$r]) {
                return $this->helper($s, $l + 1, $r) || $this->helper($s, $l, $r - 1);
            }
        }
        return true;
    }
    function helper($s, $l, $r)
    {
        var_dump($s, $l, $r);
        while ($l < $r) {
            if ($s[$l] != $s[$r]) {
                return false;
            }
            $l++;
            $r--;
        }
        return true;
    }
}