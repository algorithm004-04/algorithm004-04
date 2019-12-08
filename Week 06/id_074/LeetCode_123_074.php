<?php

class Solution {

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
function ladderLength($beginWord, $endWord, $wordList) {
    if(!in_array($endWord,$wordList)) return 0;
    $wordKv = array_flip($wordList); // 交换数组中的键和值。查询和删除key比value效率高
    $s1[] = $beginWord;
    $s2[] = $endWord; // 双向BFS
    $n = strlen($beginWord);
    $step = 0;
    while(!empty($s1)){
        $step ++;
        if(count($s1)>count($s2)){//依次双向BFS实现,始终使用变量s1去运算。
            $tmp = $s1;
            $s1 = $s2;
            $s2 = $tmp;
        }
        $s = [];
        foreach($s1 as $word_1){
            for ($i = 0; $i < $n; $i++) {
                $word1 = $word_1;
                for($ch = ord('a'); $ch <= ord('z'); $ch++){
                    $word1[$i] = chr($ch);
                    if(in_array($word1,$s2)) return $step+1;
                    if(!array_key_exists($word1,$wordKv)) continue;
                    unset($wordKv[$word1]);
                    $s[] = $word1;
                }
            }
        }
        $s1 = $s;
    }
    return 0;
}

}


