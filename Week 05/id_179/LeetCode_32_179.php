<?php
class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    public function longestValidParentheses($s)
    {
        $len = strlen($s);
        if ($len == 0) {
            return 0;
        }
        $dp = array_fill(0, $len, 0);
        $res = 0;
        for ($i=0;$i<$len;$i++) {
            if ($i && $s[$i] == ')') {
                if ($s[$i-1] == '(') {
                    $dp[$i] = $dp[$i-2] + 2;
                } elseif ($s[$i-1] == ')' && $i-$dp[$i-1]-1 >= 0 && $s[$i-$dp[$i-1]-1] == '(') {
                    $dp[$i] = $dp[$i-1]+2+$dp[$i-$dp[$i-1]-2];
                }
                if ($dp[$i] > $res) {
                    $res = $dp[$i];
                }
            }
        }
        return $res;
    }
}



$s = '';
$n = new Solution();
echo $n->longestValidParentheses($s);
