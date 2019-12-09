<?php

class Solution
{
    public $five = 0;
    public $ten = 0;
    public $twenty = 0;
    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    public function lemonadeChange($bills)
    {
        foreach ($bills as $bill) {
            if ($bill == 5) {
                $this->five++;
            }
            if ($bill == 10) {
                if ($this->five < 1) {
                    return false;
                }
                $this->five--;
                $this->ten++;
            }
            
            if ($bill == 20) {
                if ($this->ten >= 1 && $this->five >= 1) {
                    $this->ten--;
                    $this->five--;
                    $this->twenty++;
                } elseif ($this->five >= 3) {
                    $this->five -= 3;
                    $this->twenty++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}


$s = new Solution();
$data = [5,5,10,10,20];
$data = [5,5,10];
var_dump($s->lemonadeChange($data));
