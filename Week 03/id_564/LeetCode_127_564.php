<?php
class Solution {

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function swap(&$s1, &$s2) {
        $temp = $s1;
        $s1 = $s2;
        $s2 = $temp;
    }
     
    function ladderLength($beginWord, $endWord, $wordList) {
        if (!in_array($endWord, $wordList)) return 0;

        $wordList = array_flip($wordList);
        $s1[] = $beginWord;
        $s2[] = $endWord;
        $n = strlen($beginWord);

        $step = 0;
        while (!empty($s1)) {
            $step++;
            if (count($s1) > count($s2)) {
                $this->swap($s1, $s2);
            }

            $s = [];
            foreach ($s1 as $wordstr) {
                for ($i = 0; $i < $n; $i++) {
                    $word = $wordstr;
                    for ($ch = ord('a'); $ch <= ord('z'); $ch++) {
                        $word[$i] = chr($ch);
                        if (in_array($word, $s2)) {
                            return $step + 1;
                        }
                        if (!array_key_exists($word, $wordList)) {
                            continue;
                        }
                        unset($wordList[$word]);
                        $s[] = $word;
                    }
                }
            }
            $s1 = $s;
        }
        return 0;
    }
}
?>