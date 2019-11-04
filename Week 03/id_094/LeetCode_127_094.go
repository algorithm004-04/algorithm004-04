/*
 * @lc app=leetcode id=127 lang=golang
 *
 * [127] Word Ladder
 */

// @lc code=start
func ladderLength(beginWord string, endWord string, wordList []string) int {
	if patterns, ok := genPatterns(wordList, endWord); ok {
		return ladders(beginWord, endWord, patterns)
	}
	return 0
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

func ladders(beginWord, endWord string, patterns map[string][]string) int {
	begin_q := NewQueue()
	end_q := NewQueue()
	begin_v := map[string]int{beginWord:1}
	end_v := map[string]int{endWord:1}


	begin_q.Push(beginWord, 1)
	end_q.Push(endWord, 1)

	for !begin_q.Empty() && !end_q.Empty() {
		ret := bfs(begin_q, begin_v, end_v, patterns)
		if ret != 0 {
			return ret
		}
		ret = bfs(end_q, end_v, begin_v, patterns)
		if ret != 0 {
			return ret
		}
	}
	return 0
}

func bfs(q *Queue, v1, v2 map[string]int, patterns map[string][]string) int {
	tmp, s1 := q.Pop()
	for i:=0; i<len(tmp); i++ {
		bs := []byte(tmp)
		pattern := append(bs[:i], append([]byte{'*'}, bs[i+1:]...)...)
		key := string(pattern)
		for _, word := range patterns[key] {
			if s2, ok := v2[word]; ok {
				return s1 + s2
			}
			if v1[word] == 0 {
				v1[word] = s1+1
				q.Push(word, s1+1)
			}
		}
	}
	return 0
}

type Queue struct {
	data *list.List
}
type qnode struct {
	val  string
	step int
}

func NewQueue() *Queue {
	return &Queue{data: list.New()}
}

func (q *Queue) Push(str string, step int) {
	q.data.PushBack(&qnode{str, step})
}
func (q *Queue) Pop() (str string, step int) {
	t := q.data.Front()
	node := t.Value.(*qnode)
	q.data.Remove(t)
	return node.val, node.step
}
func (q *Queue) Empty() bool {
	return q.data.Len() == 0
}

// @lc code=end

