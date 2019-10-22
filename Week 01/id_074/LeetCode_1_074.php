<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        
        $count = count($nums);
        for($i=0; $i< $count; $i++){
            $ele = $target - $nums[$i];
            $keys = array_keys($nums, $ele);
            foreach($keys as $key) {
                if ( $key &&  $key != $i) {
                    return [$i, $key]; 
                }
            }
            
        }   

        return [0,0];

    }
}

