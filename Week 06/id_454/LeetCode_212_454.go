type trienode struct{
    val rune
    word string
    next map[rune]*trienode
}

func findWords(board [][]byte, words []string) []string {
    root := &trienode{next : map[rune]*trienode{}}
    for _, w := range words{
        p := root
        for i, b := range w{
            if _, ok := p.next[b]; !ok{ p.next[b] = &trienode{val:b, next:map[rune]*trienode{}} }
            if i==len(w)-1{ p.next[b].word = w }
            p = p.next[b]
        }
    }

    res := []string{}
    for i:=0; i< len(board); i++{
        for j:=0; j< len(board[i]); j++{
            dfs(board, &res, root, i,j, map[string]bool{})
        }
    }
    
    return res
}

func dfs(brd [][]byte, res *[]string, node *trienode, i,j int, visited map[string]bool){
    k := fmt.Sprintf("%v_%v", i,j)
    
    if i<0 || j<0 || i>=len(brd) || j >= len(brd[0]) || visited[k] { return }
    nn, ok:= node.next[rune(brd[i][j])]
    if !ok{ return }
    
    if len(nn.word) >0{  *res = append(*res, nn.word); nn.word ="" }
    
    visited[k]=true
    dfs(brd, res, nn, i+1, j, visited)
    dfs(brd, res, nn, i-1, j, visited)
    dfs(brd, res, nn, i, j+1, visited)
    dfs(brd, res, nn, i, j-1, visited)
    visited[k]=false
}