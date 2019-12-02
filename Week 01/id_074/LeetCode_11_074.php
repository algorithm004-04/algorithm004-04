<?php




class Solution {

    /**
     * 时间复杂度O（n^2）
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {
        
        $max = 0 ;
        for($i = 0; $i < count($height); $i++) {
            
            for ($j=$i+1; $j<count($height); $j++ ) {

                $area = min($height[$i],$height[$j]) * ($j-$i);

                $max = max($area, $max);

            }


        }

        return $max;
    }



}



class Solution {

    /**
     * 时间复杂度o(n)
     * @param Integer[] $height
     * @return Integer
     * 双指针发
     */
    function maxArea($height) {
        
        $max = 0;
        $i=0;
        $j = count($height)-1;
        while($i<$j) {

            $minHeight = $height[$i] < $height[$j] ? $height[$i++] : $height[$j --];
        
            $area = $minHeight * ($j - $i + 1);
            $max = max($area,$max);


        }
    
        return $max;
    }



}




