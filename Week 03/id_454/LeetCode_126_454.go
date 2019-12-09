import "math"

func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	words := make(map[string]struct{})
	for _, w := range wordList {
		words[w] = struct{}{}
	}
	if _, ok := words[endWord]; !ok {
		return [][]string{}
	}

	result := make([][]string, 0)

	level := 1
	length := math.MaxInt32
	visited := make(map[string]struct{})
	queue := make([][]string, 0)
	queue = append(queue, []string{beginWord})
	for len(queue) > 0 {
		ladder := queue[0]
		queue = queue[1:]

		if len(ladder) > level {
			for w := range visited {
				delete(words, w)
			}
			visited = make(map[string]struct{})
		}
		lastWord := ladder[len(ladder)-1]
		if len(ladder) > length {
			break
		} else {
			level = len(ladder)
			if lastWord == endWord {
				result = append(result, ladder)
				length = len(ladder)
			}
		}

		for i := 0; i < len(lastWord); i++ {
			for b := 'a'; b <= 'z'; b++ {
				newWord := lastWord[:i] + string(b) + lastWord[i+1:]
				if _, ok := words[newWord]; !ok || newWord == lastWord {
					continue
				}
				visited[newWord] = struct{}{}
				copyPath := make([]string, 0, len(ladder)+1)
				copyPath = append(copyPath, ladder...)
				copyPath = append(copyPath, newWord)
				queue = append(queue, copyPath)
			}
		}
	}
	return result
}
