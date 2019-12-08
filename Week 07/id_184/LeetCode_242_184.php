<?php
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        $sArr = str_split($s);
        $tArr = str_split($t);
    
        sort($sArr);
        sort($tArr);
    
        $s = implode('', $sArr);
        $t = implode('', $tArr);
    
        if ($s === $t) {
            return true;
        } else {
            return false;
        }
    }
}