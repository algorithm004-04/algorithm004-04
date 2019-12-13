### Trie树
- Trie树，又叫字典树、前缀树（Prefix Tree）、单词查找树 或 键树，是一种多叉树结构。典型应用是用于统计和排 序大量的字符串(但不仅限于 字符串)，所以经常被搜索引 擎系统用于文本词频统计。
- 基本性质
  - 结点本身不存完整单词;
  - 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串;
  - 每个结点的所有子结点路径代表的字符都不相同。
- 优点
  - 插入和查询的效率很高，都为O(m)，其中 m 是待插入/查询的字符串的长度。
  - Trie树中不同的关键字不会产生冲突。
  - Trie树只有在允许一个关键字关联多个值的情况下才有类似hash碰撞发生。
  - Trie树不用求 hash 值，对短字符串有更快的速度。通常，求hash值也是需要遍历字符串的。
  - Trie树可以对关键字按字典序排序。
- 缺点
  - hash 函数很好时，Trie树的查找效率会低于哈希搜索。
  - 空间消耗比较大。
- 代码实现
    ```php
    class Trie
    {
        private $trie = [];
    
        /**
         * Initialize your data structure here.
         */
        function __construct()
        {
        }
    
        /**
         * Inserts a word into the trie.
         * @param String $word
         * @return NULL
         */
        function insert($word)
        {
            $node = &$this->trie;
            for ($i = 0, $len = strlen($word); $i < $len; $i++) {
                if (!isset($node[$word[$i]])) {
                    $node[$word[$i]] = [];
                }
                $node = &$node[$word[$i]];
            }
            $node['#'] = 1;
        }
    
        /**
         * Returns if the word is in the trie.
         * @param String $word
         * @return Boolean
         */
        function search($word)
        {
            $node = &$this->trie;
            for ($i = 0, $len = strlen($word); $i < $len; $i++) {
                if (!isset($node[$word[$i]])) {
                    return false;
                }
                $node = &$node[$word[$i]];
            }
            return isset($node['#']);
        }
    
        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         * @param String $prefix
         * @return Boolean
         */
        function startsWith($prefix)
        {
            $node = &$this->trie;
            for ($i = 0, $len = strlen($prefix); $i < $len; $i++) {
                if (!isset($node[$prefix[$i]])) {
                    return false;
                }
                $node = &$node[$prefix[$i]];
            }
            return true;
        }
    }
    ```
### 二叉查找树
- 基本性质
  - 任意节点左子树不为空,则左子树的值均小于根节点的值.
  - 任意节点右子树不为空,则右子树的值均大于于根节点的值.
  - 任意节点的左右子树也分别是二叉查找树.
  - 没有键值相等的节点.
- 局限性
  一个二叉查找树是由n个节点随机构成,所以，对于某些情况,二叉查找树会退化成一个有n个节点的线性链。
### AVL树
- AVL树是带有平衡条件的二叉查找树,一般是用平衡因子差值判断是否平衡并通过旋转来实现平衡,左右子树树高不超过1,和红黑树相比,它是严格的平衡二叉树,平衡条件必须满足(所有节点的左右子树高度差不超过1).不管我们是执行插入还是删除操作,只要不满足上面的条件,就要通过旋转来保持平衡,而旋转是非常耗时的,由此我们可以知道AVL树适合用于插入删除次数比较少，但查找多的情况。
- 局限性
  - 由于维护这种高度平衡所付出的代价比从中获得的效率收益还大,故而实际的应用不多，更多的地方是用追求局部而不是非常严格整体平衡的红黑树.
  - 如果应用场景中对插入删除不频繁,只是对查找要求较高,那么AVL还是较优于红黑树.
### 红黑树
- 一种二叉查找树,但在每个节点增加一个存储位表示节点的颜色,可以是red或black. 通过对任何一条从根到叶子的路径上各个节点着色的方式的限制,红黑树确保没有一条路径会比其它路径长出两倍.它是一种弱平衡二叉树(由于是若平衡,可以推出,相同的节点情况下,AVL树的高度低于红黑树),相对于要求严格的AVL树来说,它的旋转次数变少,所以对于搜索,插入,删除操作多的情况下,我们就用红黑树.
- 性质
  - 每个节点非红即黑.
  - 根节点是黑的。
  - 每个叶节点(叶节点即树尾端NUL指针或NULL节点)都是黑的.
  - 如果一个节点是红的,那么它的两儿子都是黑的.
  - 对于任意节点而言,其到叶子点树NIL指针的每条路径都包含相同数目的黑节点.
### 并查集 
 - 并查集是一种树型的数据结构，用于处理一些不相交集合（Disjoint Sets UnionFind）的合并及查询问题。常常在使用中以森林来表示。 进行快速规整。常用于解决组团、配对问题。
 - 代码实现
   ```php
   class UnionFind
   {
       public $parent = [];
       public function __construct($n)
       {
           for ($i = 0; $i < $n; $i++) {
               $this->parent[$i] = -1;
           }
       }
       
       function find($i)
       {
           if ($this->parent[$i] == -1) {
               return $i;
           }
   
           return $this->find($this->parent[$i]);
       }
   
       function union($i, $j)
       {
           $i_root = $this->find($i);
           $j_root = $this->find($j);
           if ($i_root != $j_root) {
               $this->parent[$i_root] = $j_root;
           }
       }
   } 
   ```
