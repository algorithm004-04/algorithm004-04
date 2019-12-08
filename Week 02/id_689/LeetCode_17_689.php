<?php
class Solution {

    public $phone = [
        2 => 'abc',
        3 => 'def',
        4 => 'ghi',
        5 => 'jkl',
        6 => 'mno',
        7 => 'pqrs',
        8 => 'tuv',
        9 => 'wxyz',
    ];
    public $output = [];
    /**
     * @param String $digits
     * @return String[]
     */
    function letterCombinations($digits) {
        if(strlen($digits) != 0) $this->backtrack('', $digits);
        return $this->output;
    }

    function backtrack($combination, $next_digits) {
        if(strlen($next_digits) == 0){
            $this->output[] = $combination;
        } else {
            $letters = $this->phone[$next_digits[0]];
            $letters_length = strlen($letters);
            for($i = 0; $i < $letters_length; $i++) {
                $this->backtrack($combination . $letters[$i], substr($next_digits, 1));
            }
        }
    }
}