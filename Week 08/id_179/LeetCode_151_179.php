<?php
class Solution
{

    /**
     * @param String $s
     * @return String
     */
    public function reverseWords($s)
    {
        if ($s == '') {
            return '';
        }
        $words = array_filter(explode(' ', trim($s)));
        $rwords = array_reverse($words);
        return implode(' ', $rwords);
    }
}


$str = "the sky is blue";
$str = "a good   example";
$s= new Solution();
echo $s->reverseWords($str);
