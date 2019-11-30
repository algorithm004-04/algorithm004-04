/*
 * @lc app=leetcode id=212 lang=golang
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (29.94%)
 * Likes:    1553
 * Dislikes: 84
 * Total Accepted:    144.7K
 * Total Submissions: 467.8K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 *
 * Input:
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 *
 *
 * Note:
 *
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 *
 */

// @lc code=start
/* 上下左右：四连通，加上斜角：八连通
 * v1, 遍历 words，去 boards 里查询，时间复杂度：O(N*m*m*4^k)，4为四个通路，k为平均单词长度
 * v2, trie
 * 	a. 所有单词构建起一个 Trie
 *	b. 对于 boards 进行 DFS
 *	c. 时间复杂度？？？
 */

type Trie struct {
	next  map[rune]*Trie
	isEnd bool
	word  string
}

func findWords(board [][]byte, words []string) []string {
	// build a trie
	root := &Trie{next: make(map[rune]*Trie)}
	for _, word := range words {
		cur := root
		for _, v := range []rune(word) {
			if cur.next[v] == nil {
				cur.next[v] = &Trie{next: make(map[rune]*Trie)}
			}
			cur = cur.next[v]
		}
		cur.word = word
		cur.isEnd = true
	}

	// dfs
	res := []string{}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			dfs(board, root, i, j, &res)
			if len(res) >= len(words) {
				return words
			}
		}
	}

	// print output
	return res
}

func dfs(board [][]byte, trie *Trie, i, j int, res *[]string) {
	if trie.isEnd {
		*res = append(*res, trie.word)
		trie.isEnd = false
		trie.word = ""
	}
	if i < 0 || i >= len(board) || j < 0 || j >= len(board[i]) {
		return
	}
	letter := board[i][j]
	next, ok := trie.next[rune(letter)]
	if !ok {
		return
	}
	board[i][j] = '#'
	// 四连通
	dfs(board, next, i+1, j, res)
	dfs(board, next, i-1, j, res)
	dfs(board, next, i, j+1, res)
	dfs(board, next, i, j-1, res)

	board[i][j] = letter
}

// @lc code=end

