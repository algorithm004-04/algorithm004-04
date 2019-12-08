<?php

class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
        $maxIdx = $this->getHeight($height);
        
        $area = 0;
        $leftHeight = $height[0];
        for ($i = 0; $i < $maxIdx; $i++) {
            if ($leftHeight < $height[$i]) {
                $leftHeight = $height[$i];
            } else {
                $area += $height[$i] - $leftHeight;
            }
        }
        
        $rightHeight = $height[count($height) - 1];
        for ($i = count($height) - 1; $i > $maxIdx; $i--) {
            if ($rightHeight < $height[$i]) {
                $rightHeight = $height[$i];
            } else {
                $area += $height[$i] - $rightHeight;
            }
        }
        return $area;
    }

    function getHeight($height) {
        $maxId = 0;
        $maxValue = 0;
        for ($i = 0; $i < count($height); $i++) {
            if ($height[$i] > $maxValue) {
                $maxValue = $height[$i];
                $maxId = $i;
            }
        }
        return $maxId;
    }
}
?>