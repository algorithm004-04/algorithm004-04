<?php
class Solution {

    /**
     * @param String $s
     * @return Boolean
     */
    function validPalindrome($s) {
        $count = strlen($s);
        $l = 0;
        $r = $count - 1;

        while ($l < $r) {
            if ($s[$l] != $s[$r]) {
                return $this->isBool($s, $l + 1, $r) || $this->isBool($s, $l, $r - 1);
            }
            $l++;$r--;
        }
        return true;
    }

    function isBool($s, $l, $r) {
        while ($l < $r) {
            if ($s[$l] != $s[$r]) {
                return false;
            }
            $l++;$r--;
        }
        return true;
    }
}
?>