package main
//不太会 抄一遍lc的代码

type Trie struct {
	Letter      int32
	NextLetters map[int32]*Trie
	Word		string
}

func findWords(board [][]byte, words []string) []string {

	worldMap := make(map[string]struct{})

	//构建搜索树
	trie := &Trie{
		Letter:      0,
		NextLetters: make(map[int32]*Trie),
		Word:        "",
	}
	for _, word := range words {

		cur := trie
		for _, letter := range word {
			next, ok := cur.NextLetters[letter]
			if !ok {
				next = &Trie{
					Letter:      letter,
					NextLetters: make(map[int32]*Trie),
					Word:        "",
				}
			}
			cur.NextLetters[letter] = next
			cur = next
		}

		cur.Word = word
	}

	for i := range board {
		for j := range board[i] {
			DFS(board, worldMap, trie, i, j)

			if len(worldMap) >= len(words) {
				return words
			}
		}
	}

	res := make([]string, 0, len(worldMap))
	for world := range worldMap {
		res = append(res, world)
	}

	return res
}

func DFS(board [][]byte, worldMap map[string]struct{}, trie *Trie, i, j int) {

	if i < 0 || i >= len(board) || j < 0 || j >= len(board[i]) {
		return
	}

	letter := board[i][j]

	//判断是否有下一个
	next, ok := trie.NextLetters[int32(letter)]
	if !ok {
		return
	}

	//是否是完正的单词
	if next.Word != "" {
		worldMap[next.Word] = struct{}{}
	}

	board[i][j] = '#'

	DFS(board, worldMap, next, i - 1, j)
	DFS(board, worldMap, next, i + 1, j)
	DFS(board, worldMap, next, i, j - 1)
	DFS(board, worldMap, next, i, j + 1)

	board[i][j] = letter

	return
}
