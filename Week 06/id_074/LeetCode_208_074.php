<?php

class Node {
    public $is_end = false;
    public $child = [];
}

class Trie {
    private $root = null;
    
    /**
     * Initialize your data structure here.
     */
    function __construct() {
        $this->root = new Node();
    }
  
    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word) {
        $node = &$this->root;
        for($i = 0; $i < strlen($word); $i++) {
            if( ! isset($node->child[ $word{$i} ])) {
                $node->child[ $word{$i} ] = new Node();
            }
            
            $node = &$node->child[ $word{$i} ];
            
            if($i == strlen($word)-1) {
                $node->is_end = true;
            }
        }
    }
  
    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        $node = &$this->root;
        for($i = 0; $i < strlen($word); $i++) {
            if(isset($node->child[ $word{$i} ])) {
                $node = &$node->child[ $word{$i} ];
            } else {
                return false;
            }
        }
        
        return $node->is_end;
    }
  
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $node = &$this->root;
        for($i = 0; $i < strlen($prefix); $i++) {
            if(isset($node->child[ $prefix{$i} ])) {
                $node = &$node->child[ $prefix{$i} ];
            } else {
                return false;
            }
        }
        
        return true;
    }
}
