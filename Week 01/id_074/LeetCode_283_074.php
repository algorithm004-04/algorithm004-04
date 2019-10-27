<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {

        for($i = 0; $i < count($nums); $i++) {

            if($nums[$i] == 0) {

                unset($nums[$i]);
                array_push($nums, 0);
                
            }

        }
        
    }
}