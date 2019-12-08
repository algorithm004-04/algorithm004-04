<?php
class Solution {
    public $res = [];
    public $str = "";
    
    public $array = [
      "2" => ["a","b","c"],
      "3" => ["d","e","f"],
      "4" => ["g","h","i"],
      "5" => ["j","k","l"],
      "6" => ["m","n","o"],
      "7" => ["p","q","r","s"],
      "8" => ["t","u","v"],
      "9" => ["w","x","y","z"],
    ];
    /**
     * @param String $digits
     * @return String[]
     */
    function letterCombinations($digits) {
        if (!$digits) return [];
        $this->dfs($digits, 0);
        return $this->res;
    }
    
    function dfs($digits, $step) {
        if ($step == strlen($digits)) {
            $this->res[] = $this->str;
            return;
        }
        
        $key = substr($digits, $step, 1);
        $chars = $this->array[$key];
        foreach ($chars as $v) {
            $this->str .= $v;
            $this->dfs($digits, $step + 1);
            $this->str = substr($this->str, 0, strlen($this->str) - 1);
        }
    }
}
?>