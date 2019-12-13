<?php
class Trie
{
    private $trie = [];

    /**
     * Initialize your data structure here.
     */
    function __construct()
    {
    }

    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word)
    {
        $node = &$this->trie;
        for ($i = 0, $len = strlen($word); $i < $len; $i++) {
            if (!isset($node[$word[$i]])) {
                $node[$word[$i]] = [];
            }
            $node = &$node[$word[$i]];
        }
        $node['#'] = 1;
    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word)
    {
        $node = &$this->trie;
        for ($i = 0, $len = strlen($word); $i < $len; $i++) {
            if (!isset($node[$word[$i]])) {
                return false;
            }
            $node = &$node[$word[$i]];
        }
        return isset($node['#']);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix)
    {
        $node = &$this->trie;
        for ($i = 0, $len = strlen($prefix); $i < $len; $i++) {
            if (!isset($node[$prefix[$i]])) {
                return false;
            }
            $node = &$node[$prefix[$i]];
        }
        return true;
    }
}