# NOTE

##### 字典树

字典树:又称单词查找树，Trie树，是一种树形结构，是一种哈希树的变种。典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

优点：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。

基本性质：
根节点不包含字符，除根节点外每一个节点都只包含一个字符； 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串； 
每个节点的所有子节点包含的字符都不相同。

基本操作有：
查找、插入和删除,当然删除操作比较少见。

代码模板（待进一步整理）：
``` java
class Trie {

    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        HashMap<Character, TrieNode> children = root.children;
 
        for(int i=0; i<word.length(); i++) {
            
            char c = word.charAt(i);
            TrieNode t;
            
            if(children.containsKey(c)) {
                    t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
 
            children = t.children;
 
            //set leaf node
            if(i==word.length()-1) {
                t.isLeaf = true;
            }       
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode t = searchNode(word);
        if(t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
       if(searchNode(prefix) == null) {
           return false;
       } else {
           return true;
       }
    }
    
    public TrieNode searchNode(String str) {
        
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}

class TrieNode {
    
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
 
    public TrieNode() {}
 
    public TrieNode(char c){
        this.c = c;
    }
}
``` 

##### 并查集
在一些有N个元素的集合应用问题中，我们通常是在开始时让每个元素构成一个单元素的集合，然后按一定顺序将属于同一组的元素所在的集合合并，其间要反复查找一个元素在哪个集合中。

基本性质：
看似并不复杂，但数据量极大，若用正常的数据结构来描述的话，往往在空间上过大，计算机无法承受；即使在空间上勉强通过，运行的时间复杂度也极高，根本就不可能在比赛规定的运行时间（1～3秒）内计算出试题需要的结果，只能用并查集来描述。

基本操作有：
初始化
把每个点所在集合初始化为其自身。
通常来说，这个步骤在每次使用该数据结构时只需要执行一次，无论何种实现方式，时间复杂度均为O(N)。
查找
查找元素所在的集合，即根节点。
合并
将两个元素所在的集合合并为一个集合。
通常来说，合并之前，应先判断两个元素是否属于同一集合，这可用上面的“查找”操作实现。

代码模板：
``` java
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

##### 初级搜索算法：

1.BF（朴素）匹配算法
BF（朴素）是简单的模式匹配算法，就是通过主串str匹配是否存在子串sub

代码模板（待进一步整理）：
``` java
 /*
    BF算法
    i回退，j回退
    主串m个数据，子串n个数据，时间复杂度m*n
 */
public class TestDemo {
    public static int BF(char[]str,char[]sub){
        int i=0,j=0;
        while (j<sub.length && i<str.length){
            if (str[i]==sub[j]){
                i++;j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if (j==sub.length){
            return i-j;
        }else {
            return -1;
        }
    }
    public static void main(String[] args) {
        String str = "abcababcabc";
        String sub = "abcabc";
        char[] ch1 = str.toCharArray();
        char[] ch2 = sub.toCharArray();
        int index = BF(ch1,ch2);
        System.out.println("请输出主串str："+str);
        System.out.println("请输出子串sub："+sub);
        System.out.println("若找到，请输出对应的主串下标："+index);
    }
}
```

2.优化方式：不重复（fibonacci)、剪枝（生成括号问题）


3.优化搜索方向:
DFS：depth first search 深度优先搜索
代码模板：递归写法
``` java
//DFS递归实现
public void DFSWithRecursion(TreeNode root) {
    if (root == null)
        return;
 
 	//处理遍历到的TreeNode节点
 	process(node);
        
    if (root.left != null)
        DFSWithRecursion(root.left);
    if (root.right != null)
        DFSWithRecursion(root.right);
}
```
代码模板：非递归写法（Stack）
``` java
public void DFSWithStack(TreeNode root) {
     if (root == null)
         return;
     Stack<TreeNode> stack = new Stack<>();
     stack.push(root);
 
     while (!stack.isEmpty()) {
         TreeNode treeNode = stack.pop();
 
         //处理遍历到的TreeNode节点
         process(node);

         if (treeNode.right != null)
             stack.push(treeNode.right);
 
         if (treeNode.left != null)
             stack.push(treeNode.left);
     }
}
```

BFS：breadth first search 广度优先搜索
代码模板：Queue实现BFS
``` java
public void BFSWithQueue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null)
        queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode treeNode = queue.poll();
 
 		//处理遍历到的TreeNode节点
 		process(node);

        if (treeNode.left != null)
            queue.add(treeNode.left);
        if (treeNode.right != null)
            queue.add(treeNode.right);
    }

    // other processing work
}
```

##### 高级搜索算法

双向BFS搜索：
双向BFS搜索适用于知道起点和终点的场景下使用，从起点和终点两个方向开始进行搜索，
可以非常大的提高单个BFS的搜索效率。

代码模板（待进一步整理）
``` java

void BFS(){

    List<State> startSta = new ArrayList<>(N*N);
    List<State> endSta = new ArrayList<>(N*N);
    //起终状态入队
    startSta.add(new State(0, 0));
    endSta.add(new State(N-1, N-1));
    
    boolean[][] startVisited = new boolean[N][N];
    boolean[][] endVisited = new boolean[N][N];
    //标志起终状态
    startVisited[0][0] = true;
    endVisited[N-1][N-1] = true;

    int len = 1;

    while (!startSta.isEmpty() && !endSta.isEmpty()) {

        List<State> newStaSet = new ArrayList<>();
        for (State curSta : startSta) {
            int i = curSta.i, j = curSta.j;
            for (int[] pos : direc) {
	            
	            //找到解
	            if (endVisited[newSta.i][newSta.j]) {
                    return len + 1;
                }

	            //状态已经存在
	            if (visited[newSta.i][newSta.j]) {
                    continue;
                }

				newStaSet.add(newSta);
                visited[newSta.i][newSta.j] = true;
                startVisited[newSta.i][newSta.j] = true;
            }
        }
        startSta = newStaSet;
        len++;
    }
}
```

启发式搜索（优先级搜索或ASTAR算法） :
启发式搜索(Heuristically Search)又称为有信息搜索(Informed Search)，它是利用问题拥有的启发信息来引导搜索，达到减少搜索范围、降低问题复杂度的目的，这种利用启发信息的搜索过程称为启发式搜索。

启发中的估价是用估价函数表示的，如：f(n) = g(n) + h(n)
其中f(n) 是节点n的估价函数，g(n)是在状态空间中从初始节点到n节点的实际代价，h(n)是从n到目标节点最佳路径的估计代价。在这里主要是h(n)体现了搜索的启发信息，因为g(n)是已知的。如果说详细点，g(n)代表了搜索的广度的优先趋势。但是当h(n) >> g(n)时，可以省略g(n)，而提高效率。

代码模板（待进一步整理）
``` java
1、将源点加入open表
2、
while(OPEN!=NULL)
{
    从OPEN表中取f(n)最小的节点n;
    if(n节点==目标节点)
        break;
    for(当前节点n的每个子节点X)
    {
        计算f(X);
        if(XinOPEN)
            if(新的f(X)<OPEN中的f(X))
            {
                把n设置为X的父亲;
                更新OPEN表中的f(n); //不要求记录路径的话可以直接加入open表，旧的X结点是不可能比新的先出队
            }
        if(XinCLOSE)
            continue;
        if(Xnotinboth)
        {
            把n设置为X的父亲;
            求f(X);
            并将X插入OPEN表中; 
        }
    }//endfor
    将n节点插入CLOSE表中;
    按照f(n)将OPEN表中的节点排序;//实际上是比较OPEN表内节点f的大小，从最小路径的节点向下进行。
}//endwhile(OPEN!=NULL)

3、保存路径，从目标点出发，按照父节点指针遍历，直到找到起点。
```