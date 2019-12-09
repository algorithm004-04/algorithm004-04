<?php
class Solution
{

    /**
     * @param Integer[] $arr1
     * @param Integer[] $arr2
     * @return Integer[]
     */
    public function relativeSortArray($arr1, $arr2)
    {
        if (count($arr1) < count($arr2)) {
            return $arr2;
        }
        sort($arr1);
        $len2 = count($arr2);

        $res = [];
        for ($i = 0, $k = 0; $i < $len2; $i++) {
            $index = array_search($arr2[$i], $arr1);

            if ($index !== false) {
                while (isset($arr1[$index]) && $arr1[$index] == $arr2[$i]) {
                    $res[$k++] = $arr2[$i];
                    unset($arr1[$index]);
                    $index++;
                }
            }
        }
        foreach ($arr1 as $v) {
            $res[] = $v;
        }

        return $res;
    }
}

$d1 = [2,3,1,3,2,4,6,7,9,2,19];
$d2 = [2,1,4,3,9,6];

$s = new Solution();
$res = $s->relativeSortArray($d1, $d2);
print_r($res);
