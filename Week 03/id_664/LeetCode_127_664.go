
// 把word存入字典、可以利用字典快速添加、删除和查找单词

func ladderLength(beginWord string, endWord string, wordList []string) int {
	dict := make(map[string]bool)
	for _, word := range wordList {
		dict[word] = true
	}
	if _, ok := dict[endWord]; !ok {
		return 0
	}

	var queue []string
	queue = append(queue, beginWord)

	l := len(beginWord)
	steps := 0

	for len(queue) > 0 {
		steps++
		size := len(queue)
		for i := size; i > 0; i-- { // 当前层级节点
			s := queue[0] // 原始单词
			queue = queue[1:]
			chs := []rune(s)
			for i := 0; i < l; i++ {
				ch := chs[i]
				for c := 'a'; c <= 'z'; c++ { // 尝试从a-z
					if c == ch {
						continue
					}
					chs[i] = c
					t := string(chs)
					if t == endWord {
						return steps + 1
					}
					if _, ok := dict[t]; !ok {
						continue
					}
					delete(dict, t)
					queue = append(queue, t)
				}
				chs[i] = ch
			}
		}
	}
	return 0
}