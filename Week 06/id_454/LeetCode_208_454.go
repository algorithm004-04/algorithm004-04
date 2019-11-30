type Trie struct {
	next   map[rune]*Trie
	isWord bool
}

func Constructor() Trie {
	return Trie{next: make(map[rune]*Trie), isWord: false}
}

func (t *Trie) Insert(word string) {
	for _, v := range word {
		if t.next[v] == nil {
			t.next[v] = &Trie{next: make(map[rune]*Trie), isWord: false}
		}
		t = t.next[v]
	}
	t.isWord = true
}

func (t *Trie) Search(word string) bool {
	node := t.prefixNode(word)
	return node != nil && node.isWord
}

func (t *Trie) StartsWith(prefix string) bool {
	node := t.prefixNode(prefix)
	return node != nil
}

func (t *Trie) prefixNode(prefix string) *Trie {
	for _, v := range prefix {
		if t.next[v] == nil {
			return nil
		}
		t = t.next[v]
	}
	return t
}