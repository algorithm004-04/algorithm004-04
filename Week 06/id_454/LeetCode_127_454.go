ype queue struct {
    buf  []*node                                                                                               
    head int
    tail int
}

func (q *queue) push(p *node) {
    q.buf = append(q.buf, p)
    q.tail++
}

func (q *queue) pop() *node {
    r := q.buf[q.head]
    q.head++
    return r
}

func (q *queue) size() int {
    return q.tail - q.head
}

type node struct {
    visited bool
    depth int
    val string
    peers []*node
}

func peers(a string, list []*node) []*node {
    var ret []*node
    for _, b := range list {
        if len(a) == 0 || len(b.val) == 0 {
            continue
        }

        if len(a) != len(b.val) {
            continue
        }

        diff := 0
        for i := 0; i < len(a); i++ {
            if a[i] != b.val[i] {
                diff++
            }
        }
        
        if diff > 1 {
            continue
        }
        
        ret = append(ret, b)
    }
    
    return ret
}

func addPeers(n *node, nodes []*node, visited map[*node]bool) {
    n.peers = peers(n.val, nodes)
    for _, v := range n.peers {
        if visited[v] {
            continue
        }
        visited[v] = true
        addPeers(v, nodes, visited)
    }
}

func buildGraph(beginWord string, list []string) *node {
    root := &node{val:beginWord}
    nodes := make([]*node, len(list))
    for i := range nodes {
        nodes[i] = &node{val:list[i]}
    }
    addPeers(root, nodes, make(map[*node]bool))
    return root
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
    begin := buildGraph(beginWord, wordList)
    q := &queue{}
    q.push(begin)
    for q.size() > 0 {
        n := q.pop()
        if n.visited {
            continue
        }
        n.visited = true
        
        if n.val == endWord {
            return n.depth + 1
        }
        
        for _, p := range n.peers {
            if p != begin && p.depth == 0 {
                p.depth = n.depth+1
                q.push(p)
            }
        }
    }
    
    return 0
}