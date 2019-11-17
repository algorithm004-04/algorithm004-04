<?php
class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills) {
        $five = 0;
        $ten = 0;
        foreach ($bills as $bill) {
            if ($bill == 5) {
                $five ++;
            } else if ($bill == 10) {
                if ($five == 0) return false;
                $five --;
                $ten ++;
            } else {
                if ($five > 0 && $ten > 0) {
                    $five --;
                    $ten --;
                } else if ($five >= 3) {
                    $five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
?>