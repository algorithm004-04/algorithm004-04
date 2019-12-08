<?php

class Solution
{

    /**
     * @param Integer $n
     * @return Boolean
     */
    function isPowerOfTwo($n)
    {
        if ($n < 1) {
            return false;
        }
        return (($n & ($n - 1)) == 0);
    }
}
