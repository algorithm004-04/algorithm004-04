<?php
class Solution
{

    /**
     * @param String $S
     * @return String
     */
    public function reverseOnlyLetters($S)
    {
        $len = strlen($S);
        if ($len == 0) {
            return $S;
        }
        for ($i=0,$j=$len-1; $i<=$j;) {
            while (!ctype_alpha($S[$i]) && $i<$j) {
                $i++;
            }
            while (!ctype_alpha($S[$j]) && $i<$j) {
                $j--;
            }
            $t = $S[$i];
            $S[$i] = $S[$j];
            $S[$j] = $t;
            $i++;
            $j--;
        }
        return $S;
    }
}

$str = "7_28]";
$s= new Solution();
echo $s->reverseOnlyLetters($str);
