<?php

class Solution
{

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    public function ladderLength($beginWord, $endWord, $wordList)
    {
        if (!in_array($endWord, $wordList)) {
            return 0;
        }
        $wordList= array_flip($wordList);
        $len = strlen($beginWord);

        $next_front = [$beginWord];
        $next_end  = [$endWord];
        $letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];

        $step = 1;
        while ($next_front) {
            $step++;
            $t = [];
            foreach ($next_front as $word) {
                for ($i=0;$i<$len;$i++) {
                    foreach ($letters as $_letter) {
                        $_next = substr($word, 0, $i) . $_letter . substr($word, $i+1);
                    
                        if (in_array($_next, $next_end)) {
                            return $step;
                        }
                        if (substr($word, $i, 1) != $_letter && array_key_exists($_next, $wordList)) {
                            $t[] = $_next;
                            // printf("%s\n", $_next);
                            unset($wordList[$_next]);
                        }
                    }
                }
            }
            if (count($t) > count($next_end)) {
                $next_front = $next_end;
                $next_end = $t;
            } else {
                $next_front = $t;
            }
        }
        return 0;
    }
}

$beginWord = "hit";
$endWord = "cog";
$wordList = ["hot","dot","dog","lot","log","cog"];


$beginWord = "hot";
$endWord = "dog";
$wordList = ["hot","dot"];


$beginWord = "hot";
$endWord = "dog";
$wordList = ["hot","dog"];

$s = new Solution();
echo $s->ladderLength($beginWord, $endWord, $wordList);
