<?php

class Solution
{

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($beginWord, $endWord, $wordList)
    {
        $L = strlen($beginWord);
        $all_combo_dict = [];
        foreach ($wordList as $word) {
            for ($i = 0; $i < $L; $i++) {
                $all_combo_dict[substr($word, 0, $i) . '*' . substr($word, $i + 1)][] = $word;
            }
        }

        $queue[] = [$beginWord, 1];
        $visited[$beginWord] = 1;
        while ($queue) {
            $data = array_shift($queue);
            $current_word = $data[0];
            $level = $data[1];
            for ($j = 0; $j < $L; $j++) {
                $intermediate_word = substr($current_word, 0, $j) . '*' . substr($current_word, $j + 1);
                if (isset($all_combo_dict[$intermediate_word])) {
                    foreach ($all_combo_dict[$intermediate_word] as $word) {
                        if ($word == $endWord) {
                            return $level + 1;
                        }
                        if (!isset($visited[$word])) {
                            $visited[$word] = 1;
                            $queue[] = [$word, $level + 1];
                        }
                    }
                    $all_combo_dict[$intermediate_word] = [];
                }
            }
        }

        return 0;
    }
}