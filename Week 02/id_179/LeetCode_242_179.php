<?php

class Solution
{

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    public function isAnagram($s, $t)
    {
        $t1 = count_chars($s, 1);
        $t2 = count_chars($t, 1);
        return $t1 == $t2;
    }
}
