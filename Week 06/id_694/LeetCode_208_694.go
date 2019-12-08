/*
 * @lc app=leetcode.cn id=208 lang=golang
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (61.77%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    16.2K
 * Total Submissions: 26K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
type Trie struct {
	children [26]*Trie
	data     byte
	isEnd    bool
}

// Constructor Initialize your data structure here.
func Constructor() Trie {
	t := new(Trie)
	return *t
}

// Insert inserts a word into the trie.
func (this *Trie) Insert(word string)  {
	p := this
	for i := 0; i < len(word); i++ {
		idx := int(word[i] - 'a')
		if p.children[idx] == nil {
			node := new(Trie)
			p.children[idx] = node
		}
		p = p.children[idx]
	}
	p.isEnd = true
}

// Search returns if the word is in the trie. 
func (this *Trie) Search(word string) bool {
	p := this
	for i := 0; i < len(word); i++ {
		idx := int(word[i] - 'a')
		if p.children[idx] == nil {
			return false
		}
		p = p.children[idx]
	}

	return p.isEnd
}

// StartsWith Returns if there is any word in the trie that starts with the given prefix.
func (this *Trie) StartsWith(prefix string) bool {
	p := this
	for i := 0; i < len(prefix); i++ {
		idx := int(prefix[i] - 'a')
		if p.children[idx] == nil {
			return false
		}
		p = p.children[idx]
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

