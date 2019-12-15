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
        $this->len = strlen($beginWord);
        $this->prepare($wordList);
        if (empty($beginWord) || empty($endWord) || empty($wordList) || !in_array($endWord, $wordList)) {
            return 0;
        }

        return $this->search($beginWord, $endWord);
    }
    
    public $store = [];
    public $q = [];
    public $used=[];

    public function prepare($wordlist)
    {
        // 构建hash结构，加快查找邻接节点的速度
        // 与字符长度有关, 当字符长度过长时，是否仍有效？？
        foreach ($wordlist as $word) {
            for ($i=0; $i<$this->len;$i++) {
                $key = substr($word, 0, $i).'*'.substr($word, $i+1);
                $t[$key][] = $word;
            }
        }
        $this->store = $t;
    }

    public function search($from, $to)
    {
        $this->q=[$from];
        $lev = 1;
        while ($this->q) {
            $q = [];
            foreach ($this->q as $_last) {
                if (in_array($_last, $this->used)) {
                    continue;
                }
                if ($_last == $to) {
                    return $lev;
                }
                $this->used[] = $_last;

                for ($i=0;$i<$this->len;$i++) {
                    $k = substr($_last, 0, $i).'*'.substr($_last, $i+1);
                    foreach ($this->store[$k] as $v) {
                        $q[] = $v;
                    }
                }
            }
            $this->q = $q;
            $lev++;
        }
        return 0;
    }
}
