/*
 * @lc app=leetcode id=126 lang=golang
 *
 * [126] Word Ladder II
 */

// @lc code=start
func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	ret := [][]string{}
	if patterns, ok := genPatterns(wordList, endWord); ok {
		bfs(beginWord, endWord, patterns, &ret)
	}
	return ret
}

func genPatterns(wordList []string, end string) (map[string][]string, bool) {
	ret := map[string][]string{}
	valid := false
	for _, word := range wordList {
		for i:=0; i<len(word); i++ {
			bs := []byte(word) //bs一定要放在循环内
			pattern := append(bs[:i], append([]byte{'*'}, bs[i+1:]...)...)
			key := string(pattern)
			ret[key] = append(ret[key], word)
			if end == word {
				valid = true
			}
		}
	}
	return ret, valid
}
//bfs + isfound + subvisited
func bfs(begin, end string, patterns map[string][]string, ret *[][]string) {
	q := NewQueue()
	path := []string{begin}
	q.Push(path) //queue保存路径
	visited := map[string]bool{begin:true} //visit保存节点

	isFound := false //是否找到end
	for !q.Empty() && !isFound {
		levelSize := q.Size()
		subVisited := []string{} //当前层已访问节点
		for i:=0; i<levelSize; i++ {
			path = q.Pop()
			tmp := path[len(path)-1]
			words := generateNextWords(tmp, patterns)
			for _, word := range words {
				if !visited[word] {
					//这里要新建一个slice，保证互不影响！！！
					//如果用newpath := append(path, word)可能会指向path，如果path改动会影响newpath
					newpath := append([]string{}, append(path, word)...)
					q.Push(newpath)
					subVisited = append(subVisited, word)

					if word == end {
						isFound = true
						*ret = append(*ret, newpath)
					}

				}
			}
		}
		//同一level遍历结束后才可以添加到visit
		for _, v := range subVisited {
			visited[v] = true
		}
	}
}



func generateNextWords(tmp string, patterns map[string][]string) []string {
	ret := []string{}

	for i:=0; i<len(tmp); i++ {
		bs := []byte(tmp)
		pattern := append(bs[:i], append([]byte{'*'}, bs[i+1:]...)...)
		key := string(pattern)
		ret = append(ret, patterns[key]...)
	}
	return ret
}

type Queue struct {
	data *list.List
}

func NewQueue() *Queue {
	return &Queue{data: list.New()}
}

func (q *Queue) Push(val []string) {
	q.data.PushBack(val)
}
func (q *Queue) Pop() []string {
	t := q.data.Front()
	node := t.Value.([]string)
	q.data.Remove(t)
	return node
}
func (q *Queue) Empty() bool {
	return q.Size() == 0
}
func (q *Queue) Size() int {
	return q.data.Len()
}

// @lc code=end

