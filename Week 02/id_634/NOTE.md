# NOTE

### 学习总结:

##### 哈希表、映射、集合的实现与特性总结
hash表 小、碰撞 退化为链表
hashmap key-value对，key不重复
hashset 值不重复

做题四件套：
1.clarification 和业务方过一遍澄清题目
2.possible solutions --> optimal  (time & space) 列出可能的解法-->从中找出最优解
3.code 写代码
4.test cases 测试样例

养成收藏精选代码的习惯：收藏代码片段 并写明思路  精选代码库
https://shimo.im/docs/R6g9WJV89QkHrDhr/read

##### 二叉树、二叉搜索树的实现和特性总结链表和跳表
升维

树和图关键差别 有没有环
链表特殊化的树
树是特殊化的图

树的原因：棋类
树节点代码：Python、Java、C++
遍历代码：
1.前序（Pre-Order）：根-左-右
2.中序（In-Order）：左-根-右
3.后序（Post-Order）：左-右-根

递归搜索

二叉树 
常见操作log(n)

树的面试题解法一般都是递归，为什么？

##### 递归的实现、特性以及思维要点
代码模板4步
1.递归终结条件 recursion terminator
2.处理当前层逻辑 process logic in current level
3.下探到下一层 drill down
4.清理当前层 reverse the current level status if needed

思维要点
1.不要人肉进行递归（最大误区）
2.找到最近最简单的方法，将其拆解成可重复解决的问题（重复子问题）
3.数学归纳法思维

##### 分治、回溯的实现和特性

思想：不管递归、分治、回溯最后本质就是找重复性及分解问题

分治
递归状态树时对一个问题化解为几个子问题
n！分解为1个子问题
斐波拉契数列、爬楼梯、抛硬币等分解为多个子问题

回溯
采用试错的思想，尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确解时，将取消上一步甚至是上几步的计算，再通过其他的可能分步解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述步骤后可能出现两种情况：
1.找到一个可能存在的正确的答案；
2.在尝试了所有可能的分步方法后宣告该问题没有答案；
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算；

解题思路：
1.暴力
2.分治
3.牛顿迭代法

### 哈希表、映射、集合的实现与特性作业

##### Java HashMap 源码分析:
特性：
1. Java为数据结构中的映射定义了一个接口java.util.Map，此接口主要有四个常用的实现类，分别是HashMap、Hashtable、LinkedHashMap和TreeMap；
2. 数据结构实现 HashMap是数组+链表+红黑树（JDK1.8增加了红黑树部分）实现；
3. HashMap就是使用哈希表来存储的。哈希表为解决冲突，可以采用开放地址法和链地址法等来解决问题；
4. Java中HashMap采用了链地址法。链地址法，就是数组加链表的结合。在每个数组元素上都一个链表结构，当数据被Hash后，得到数组下标，把数据放在对应下标元素的链表上； 
5. 使用的是2次幂的扩展(指长度扩为原来2倍)，所以，元素的位置要么是在原位置，要么是在原位置再移动2次幂的位置；
6. 在多线程使用场景中，应该尽量避免使用线程不安全的HashMap，而使用线程安全的ConcurrentHashMap；
7. JDK1.8引入红黑树大程度优化了HashMap的性能；

putMapEntries 方法的实现
``` java
final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();//传进来的map的键值对的个数
        if (s > 0) {
            if (table == null) { // pre-size
                //说明这个table还没分配内存初始化
                
                float ft = ((float)s / loadFactor) + 1.0F;
                //ft是，如果根据传进来的map的node的数量，创建table分配table，table的capacity是多少
                
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                         (int)ft : MAXIMUM_CAPACITY);
                if (t > threshold)
                    
                    //给threshold赋值
                    threshold = tableSizeFor(t);
            }
            else if (s > threshold)
                
                //说明m的个数比所在map最多可以存储的node数量要多，所以要扩容或者是为table分配内存。
                resize();//这个方法可以扩容和为table分配初始的内存。
            
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                //利用entrySet获取这个Map中所有node的一个Set
                //然后调用putVal()方法来为本HashMap添加node，或者说添加键值对。
                
                K key = e.getKey();
                V value = e.getValue();
                putVal(hash(key), key, value, false, evict);
            }
        }
    }
``` 
这个方法是putAll()方法还有构造器传map进来的话，这两个方法的内部相关实现。

这个float ft = ((float)s / loadFactor) + 1.0F;这一行代码中为什么要加1.0F我不太懂，网上有说是可以节省一次resize()，也有说精确小数点后几位……emm不知道。

关于这个putVal()方法，在下面会介绍到。


get 方法的实现
``` java
public V get(Object key) {
        //直接调用getNode()然后返回node的key
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    /**
     * Implements Map.get and related methods
     *
     * @param hash hash for key 这个key instance的经过hash()过的hash值
     * @param key the key
     * @return the node, or null if none
     */
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            //进来后tab是当前table，n是table的capacity，first是这个key对应的那个位置的桶的第一个node
            
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                //看这个桶的第一个node的key是不是这个要get的key
                //因为有些对象的引用不一样，但equals是一样的，像是文字一样的String对象
                
                //看了后面的代码发现，很多涉及查找的都是这样先桶的第一个node进行比较。
                
                return first;
            if ((e = first.next) != null) {
                //第一个node不是要get的那个key，而且有下一个元素，也就是可能是链表也可能是树
                
                if (first instanceof TreeNode)//如果是树，则交给树的getTreeNode的实现来完成
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    //这里就是这个桶下面有链表的情况，就遍历链表咯
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
``` 

put 方法的实现
``` java
public V put(K key, V value) {
        //调用putVal方法
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value这个值如果为true，就不改变原来的值，就如果put是覆盖原来的key的值，这个又为true的话就不能改变喔，虽然不知道哪里用hh
     * @param evict if false, the table is in creation mode.这个值如果为false的话，这个table就处于一个创造的模式，就是那个传map的构造器在初始化当前map，然后间接调用的这个方法。
     * @return previous value, or null if none
     */
    //put方法里面调用的后面的两个参数分别是false和true，说明可以覆盖原来的key的value；不是一个creation mode
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            //进来这里的话说明这个table还没分配空间呢，tab是table，然后n是table的capacity
            n = (tab = resize()).length;//这一步相当于调用resize()方法为table分配内存并返回一个node数组作为table，然后将这个新的table的capacity给n
        
        if ((p = tab[i = (n - 1) & hash]) == null)
            //p是这个要put的key的对应的table中的那个桶的第一个node，i是这个key对应的那个桶的index
            //如果这个桶为空，说明还没冲突，就新建一个普通的结点。
            
            tab[i] = newNode(hash, key, value, null);
        else {
            //否则就是有冲突了，可能这个桶下是链表也可能是树
            
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                //先判断桶中的第一个node的key是不是这个要put的key，是的话将这个node赋值给e
                
                e = p;
            else if (p instanceof TreeNode)
                //如果第一个不是那个key，先看这个node是不是树，是的话交给树的操作。
                
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            
            else {
                //说明这个桶下面接的是链表，而且第一个不是正确的要put的key，那就遍历链表找咯
                
                for (int binCount = 0; ; ++binCount) {//遍历的时候要数着node的数量，因为可能添加的时候load_factor要超过，要变成树。
                    if ((e = p.next) == null) {//e往下遍历
                        //这句之后，e就是下一个结点，如果进入这个条件里面，说明链表已经到头了
                        //而且还没找到那个key，所以就插入新结点了
                        //插入后break，这时候e指向null
                        
                        p.next = newNode(hash, key, value, null);//这一步就是插入的那个语句
                        
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            //添加了新结点嘛，然后就要看这个桶的链表的node数量过多没，过多可能就要进行树化操作。
                            //在treeifyBin方法中还有个判断map中键值对总数超过64没的操作，超过了才树化。
                            
                            treeifyBin(tab, hash);//这个方法的操作是，把这个桶的单向链表变成树
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        //如果遍历中发现有相同的key，就跳出来
                        //这个时候e指的是key和要put的那个key相等的node
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                //e不为null的话，说明上面的操作找到了 一个key和要put的可以一样的node
                //这个e指的就是那个key和put那个key一样的node
                
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)//条件允许，覆盖
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;//到了这里说明这个key还不存在，那么就要insert一个node，hashMap结构要改变所以这个值加一
        if (++size > threshold)
            //插入后size大于阈值，
            
            resize();
        afterNodeInsertion(evict);
        return null;
    }
``` 

##### Red-Black Tree:
Red-Black Tree的简介
一棵拥有n个元素的RB树，树的高度最多为2log(n + 1)，所以操作的时间复杂度是O(logN)级别的。红黑树看名称就知道，是个带颜色的树，也是二叉查找树，属于但又不严格属于平衡二叉树（AVL），因为没有像平衡二叉树一样，严格规定平衡因子的绝对值要小于等于1，而是靠颜色规定来达到高性能。

RB-Tree 的特性
1.每个结点，要么是红色，要么是黑色。
2.根节点是黑色的。
3.每个叶节点，或者说是NIL节点（也可以说是null空结点）都是黑色的。
4.如果一个结点是红色的，那么它的爸爸不能是红色，它的子女也不能是红色，总之红黑树中不允许连续的两个红色结点出现。
5.对于每个结点，从该结点到其后代的所有叶节点的简单路径上，均包含相同数目的黑色节点。

参考：
https://blog.csdn.net/lm2009200/article/details/70162811
https://blog.csdn.net/lm2009200/article/details/70148565

##### Fibonacci算法实现的几种方法:
公式：F(n) = F(n-1) + F(n-2)
假设第一个数是0，第二个数是1

1.迭代加法：
``` java
long long fabonacci_first(int n) {
	long long a = 0, b = 1;
	if (n == 1) return a;
	else if (n == 2) return b;
	else {
		for (int i = 3; i <= n; i++) {
			b = a + b;
			a = b - a;
		}
		return b;
	}
}
``` 

2.利用数组先存储数字，直接返回结果，耗费空间:
``` java
long long fabonacci_second(int n) {
	long long arr[50];
	arr[1] = 0; arr[2] = 1;
	for (int i = 3; i < 100; i++) 
		arr[i] = arr[i-1] + arr[i-2];
	return arr[n];
}
```

3.二分递归，由于每次都需要重新计算，损耗大量时间和空间，时间复杂度O(2^n)：
``` java

long long fabonacci_third(int n) {
	if (n == 1) return 0;
	else if (n == 2) return 1;
	else return fabonacci_second(n-1) + fabonacci_second(n-2); 
}
```

4.尾递归:
``` java
long long fabonacci_fourth(long long first, long long second, int n) { //传入时first = 0，second = 1 
	if (n == 1) return first;
	else if (n == 2) return second;
	else if (n == 3) return first + second;
	else return fabonacci_fourth(second, first + second, n - 1);
}
```

5.备忘录法，使用递归方法，但利用数组来存储来避免重复计算子问题：
``` java
long long arr[100];
 
long long fibonacci_fifth(int n) {
	if (arr[n] > 0) return arr[n];
	if (n == 1) return 0;
	if (n == 2) return 1;
	arr[n] = fibonacci_fifth(n-1) + fibonacci_fifth(n-2);
	return arr[n];
```

  

