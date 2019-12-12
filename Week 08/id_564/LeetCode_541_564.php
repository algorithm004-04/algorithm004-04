<?php
class Solution {

    function reverseStr($s, $k) {
        $str = str_split($s, $k);
        
        for ($i = 0; $i < count($str); $i += 2) {
            $res .= strrev($str[$i]). $str[$i+1];
        }

        return $res;
    }
}
?>