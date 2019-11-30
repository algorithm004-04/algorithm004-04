/*
 * @lc app=leetcode id=208 lang=golang
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (40.45%)
 * Likes:    2046
 * Dislikes: 36
 * Total Accepted:    218.1K
 * Total Submissions: 519.5K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 *
 * Note:
 *
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 *
 */

// @lc code=start
/*
 * PS:
 * Testcase equivalent to 14/15:
 * ["Trie","insert","insert","search"]\n[[],["a"],["pa"],["p"]]
 * Ref: https://leetcode.com/problems/implement-trie-prefix-tree/discuss/164814/1415-Test-Cases-Passed
 */
type Node struct {
	next      map[string]*Node
	endOfWord bool
}

type Trie struct {
	root *Node
}

func NewNode() *Node {
	return &Node{next: make(map[string]*Node)}
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{NewNode()}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	cur := this.root

	for _, v := range []rune(word) {
		c := string(v)
		if cur.next[c] == nil {
			cur.next[c] = NewNode()
		}
		cur = cur.next[c]
	}
	cur.endOfWord = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	cur := this.root

	for _, v := range []rune(word) {
		c := string(v)
		if cur.next[c] == nil {
			return false
		}
		cur = cur.next[c]
	}
	return cur.endOfWord
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	cur := this.root

	for _, v := range []rune(prefix) {
		c := string(v)
		if cur.next[c] == nil {
			return false
		}
		cur = cur.next[c]
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
// @lc code=end
