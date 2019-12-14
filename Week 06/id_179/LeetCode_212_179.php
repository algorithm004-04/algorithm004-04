<?php


class Node
{
    public $alphabet = null;
    public $children = [];


    public function __construct($val = '')
    {
        $this->alphabet = $val;
    }
}


class Solution
{
    public $row;
    public $col;
    public $root;
    public $board;
    public $tries = [];
    public $words;


    public function __construct()
    {
        $this->root = new Node();
    }


    /**
     * @param String[][] $board
     * @param String[] $words
     * @return String[]
     */
    public function findWords($board, $words)
    {
        if ($this->row = count($board)) {
            $this->col = count($board[0]);
        }
        $this->board = $board;
        $this->words = $words;

        foreach ($words as $word) {
            $branch[$word[0]] = str_split($word);
        }

        for ($i = 0; $i < $this->row; $i++) {
            for ($j = 0; $j < $this->col; $j++) {
                if (!array_key_exists($board[$i][$j], $branch)) {
                    continue;
                }
                $this->trie($i, $j, [], []);
            }
        }
        
        foreach ($words as $word) {
            if ($this->search($word)) {
                $this->tries[] = $word;
            }
        }
        return $this->tries;
    }


    public $used = [];


    public function trie($i, $j, $used, $strs, $lev = 0)
    {
        if ($i < 0 || $j < 0 || $i >= $this->row || $j >= $this->col || in_array([$i, $j], $used)) {
            return;
        }

        $used[] = [$i, $j];
        $str = '';
        foreach ($used as $item) {
            $str .= $this->board[$item[0]][$item[1]];
        }
        foreach ($this->words as $word) {
            if (strpos($word, $str) === 0 && !in_array($str, $strs)) {
                $strs[] = $str;

                $this->insert($str);

                $this->trie($i, $j - 1, $used, $strs, $lev);
                $this->trie($i, $j + 1, $used, $strs, $lev);
                $this->trie($i - 1, $j, $used, $strs, $lev);
                $this->trie($i + 1, $j, $used, $strs, $lev);
            }
        }
    }


    public function insert($alphabet)
    {
        $cur = $this->root;
        for ($i = 0, $len = strlen($alphabet); $i < $len; $i++) {
            $_cur = substr($alphabet, $i, 1);
            $flag = false;
            foreach ($cur->children as $key => $child) {
                if ($key == $_cur) {
                    $flag = true;
                    break;
                }
            }
            if (!$flag) {
                $cur->children[$_cur] = new Node($_cur);
            }
            $cur = $cur->children[$_cur];
        }
    }


    public function search($str)
    {
        $cur = $this->root;
        $len = strlen($str);
        for ($i = 0; $i < $len; $i++) {
            $_cur = substr($str, $i, 1);
            $flag = false;
            foreach ($cur->children as $key => $child) {
                if ($key == $_cur) {
                    $cur = $child;
                    $flag = true;
                    break;
                }
            }
            if (!$flag) {
                return false;
            }
        }
        return true;
    }
}




$words = ["oath","pea","eat","rain"];
$board =[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
];

$s = new Solution();
print_r($s->findWords($board, $words));
