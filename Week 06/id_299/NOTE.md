# NOTE

# 字典树
1. 字典树，机Tire树，又称单词查找树或者键树，树形结构。
2. 最大的优点：最大限度的减少无谓的字符串比较，查询效率比哈希表高

## 基本性质
1. 节点本身不存完整单词
2. 根节点到某一个节点，路径上经过的字符串连接起来，为该节点对应的字符串
3. 每个节点所有子节点路径带别熬字符都不同

## 模板
```py
class Trie(object):
  
	def __init__(self): 
		self.root = {} 
		self.end_of_word = "#" 
 
	def insert(self, word): 
		node = self.root 
		for char in word: 
			node = node.setdefault(char, {}) 
		node[self.end_of_word] = self.end_of_word 
 
	def search(self, word): 
		node = self.root 
		for char in word: 
			if char not in node: 
				return False 
			node = node[char] 
		return self.end_of_word in node 
 
	def startsWith(self, prefix): 
		node = self.root 
		for char in prefix: 
			if char not in node: 
				return False 
			node = node[char] 
		return True
```
## 应用
1. 用于统计和排序大量的字符串(但不仅限于字符串)，经常被搜索引擎系统用于文本词频的统计，
2. 前缀感应后推


## 案例
单词搜索2 https://leetcode-cn.com/problems/word-search-ii/submissions/
```java
public class LeetCode_212_299 {
    private static int rows;
    private static int cols;
    //定义四个搜索的四个方向
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'},
        };
        String[] words = {"oath","pea","eat","rain"};
        List<String> list = findWords(board,words);
        for(String l : list){
            System.out.println("result---->"+l);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        // 构建字典树
        WordTrie wordTrie = new WordTrie();
        TrieNode root = wordTrie.root;
        // 时间复杂度：构建字典树的时间复杂度为O(n)
        for(String s: words){
          wordTrie.insert(s);
        }

        // 使用set防止重复
        Set<String>  result = new HashSet<>();
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // 遍历整个二维数组
        // 到这里的时间复杂度：O(n) + O(n2)
        for(int i =0;i< rows;i++){
            for(int j =0;j < cols; j++){
                // 到这里的时间复杂度：O(n) + O(n2) * 4^k(4个方向 DFS) 可能分析的不对
                find(board,visited, i, j,result,root);
            }
        }
        return new LinkedList<String>(result);
    }

    private static void find(char[][] board ,boolean[][] visited, int i ,int j,Set<String> result,TrieNode cur){
        // 判断是否已经访问过,以及超出边界
        if(i >= rows || i< 0 || j >= cols || j <0 || visited[i][j]){
            return;
        }
        cur = cur.child[board[i][j] - 'a'];
        visited[i][j]= true;

        if(cur==null){
            // 如果不匹配回退
            visited[i][j]= false;
            return;
        }
        if(cur.isLeaf){
            result.add(cur.val);
        }
        for (int k=0;k<4;k++){
            find(board,visited,i + directions[k][0],j + directions[k][1],result,cur);
        }
        visited[i][j] = false;
    }
}

class WordTrie{
    public TrieNode root = new TrieNode();
    public void insert(String s){
        TrieNode cur = root;
        for(char c: s.toCharArray()){
            if(cur.child[c - 'a'] ==null){
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else {
                cur = cur.child[c - 'a'];
            }
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}

//字典树结点
class TrieNode{
    public String val;
    public TrieNode[] child = new TrieNode[26];
    public boolean isLeaf = false;

    TrieNode(){}
}
```

# 并查集

1. makeSet(s): 建立一个新的并查集，其中包含s个单位元素集合
2. unionSet(x,y):把元素x和元素y所在集合合并，要求x和y所在集合不相交，如果相交则不合并
3. find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否在同一个集合
4. 应用场景：组团、配对问题(比如判断两个个体是不是在一个集合中)

## 解决思路
1. DFS
2. BFS
3. 并查集 

## 模板

```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

```python
def init(p): 
	# for i = 0 .. n: p[i] = i; 
	p = [i for i in range(n)] 
 
def union(self, p, i, j): 
	p1 = self.parent(p, i) 
	p2 = self.parent(p, j) 
	p[p1] = p2 
 
def parent(self, p, i): 
	root = i 
	while p[root] != root: 
		root = p[root] 
	while p[i] != i: # 路径压缩 ?
		x = i; i = p[i]; p[x] = root 
	return root
```
