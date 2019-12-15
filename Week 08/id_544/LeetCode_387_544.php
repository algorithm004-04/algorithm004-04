<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function firstUniqChar($s) {
        $length = strlen($s);
        if($length == 1){
            return 0;
        }else{
            $hash = [];
            for($i = 0; $i < $length; $i++){
                if(!isset($hash[$s[$i]])){
                    $hash[$s[$i]] = 1;
                }else{
                    $hash[$s[$i]]++;
                }
            }
            var_dump($hash);
            for($j = 0; $j < $length; $j++){
                if($hash[$s[$j]] == 1) return $j;
            }
        }
        return -1;
    }
}
