<?php
class Solution
{
    /**
     * @param String[][] $board
     * @param String[] $words
     * @return String[]
     */

    public $m = 0;
    public $n = 0;
    public $trie = [];
    public $result = [];
    public $positions = [[1, 0], [-1, 0], [0, 1], [0, -1]];

    function findWords($board, $words)
    {
        foreach ($words as $word) {
            $node = &$this->trie;
            for ($i = 0, $length = strlen($word); $i < $length; $i++) {
                if (!isset($node[$word[$i]])) {
                    $node['val'] = substr($word, 0, $i);
                    $node[$word[$i]] = [];
                }
                $node = &$node[$word[$i]];
            }

            $node['val'] = substr($word, 0, $length);
            $node['#'] = 1;
        }

        $this->m = count($board);
        $this->n = count($board[0]);

        for ($i = 0; $i < $this->m; $i++) {
            for ($j = 0; $j < $this->n; $j++) {
                $this->dfs($board, $i, $j, $this->trie);
            }
        }

        return $this->result;
    }

    function dfs($board, $i, $j, $root)
    {
        if ($i < 0 || $i >= $this->m || $j < 0 || $j >= $this->n || !isset($root[$board[$i][$j]])) {
            return;
        }

        $cur = $root[$board[$i][$j]];
        if (isset($cur['#'])) {
            $this->result[$cur['val']] = $cur['val'];
        }

        $raw_character = $board[$i][$j];
        $board[$i][$j] = '-';
        foreach ($this->positions as $position) {
            $this->dfs($board, $i + $position[0], $j + $position[1], $cur);
        }

        $board[$i][$j] = $raw_character;
    }
}
