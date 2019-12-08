<?php
class Solution
{

    /**
     * @param String[] $strs
     * @return String[][]
     */
    // public function groupAnagrams($strs)
    // {
    //     $store = [];
    //     $res = [];
    //     $index = 0;
       
    //     foreach ($strs as $k=>$str) {
    //         $t = count_chars($str, 1);
    //         $next = 0;
    //         if (($key = array_search($t, $store)) !== false) {
    //             $res[$key][] = $str;
    //         } else {
    //             // not found
    //             $store[$index] = $t;
    //             $res[$index][] = $str;
    //             $index++;
    //         }
    //     }
    //     return $res;
    // }

    public function groupAnagrams($strs)
    {
        $store = [];
        foreach ($strs as $str) {
            $t = str_split($str);
            sort($t);
            $store[$t][] = $str;
        }
        return array_values($store);
    }
}
