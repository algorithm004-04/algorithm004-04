# NOTE
桶hash table.但是如果桶的数量太大，会变成平衡树结构保证O(logn)，
不是synchronized 的方法，多个线程可同时访问hashmap。可用collection.synchronized(new HashMap()),使其是synchronized。
Hashmap 树化，桶的最小阈值 64；

关键参数：
	容量（capacity）:
	加载因数（load factor）: 自动扩容的阈值（rehash 代价高），默认0.75
	
Put 方法：
 Put : -> return putVal(hash(key),key,value,false,true);  给key计算hash值，
	Putval :
		final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
		                   boolean evict) {
		        Node<K,V>[] tab; Node<K,V> p; int n, i;
		        if ((tab = table) == null || (n = tab.length) == 0)   // 空表则扩容
		            n = (tab = resize()).length;
		        if ((p = tab[i = (n - 1) & hash]) == null)      //计算hash值
		            tab[i] = newNode(hash, key, value, null);   //不存在则添加一个 非树节点  newNode就是添加非树节点。
		        else {                                                               //存在
		            Node<K,V> e; K k;                                                
			   if (p.hash == hash &&
		                ((k = p.key) == key || (key != null && key.equals(k))))    //判断table[i]的首个元素是否和key一样，如果相同直接覆盖value，否则else
		                e = p;
		            else if (p instanceof TreeNode)    key不一样，判断是否是树节点
		                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);   //如果是判断是树节点，则调用putTreeVal
		            else {
		                for (int binCount = 0; ; ++binCount) {       //不是树节点，遍历链表
		                    if ((e = p.next) == null) {
		                        p.next = newNode(hash, key, value, null);     //添加新节点
		                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st    //如果桶数超过阈值，则树化这些
		                            treeifyBin(tab, hash);
		                        break;
		                    }
		                    if (e.hash == hash &&   //  如果存在相同hash 值，则覆盖
		                        ((k = e.key) == key || (key != null && key.equals(k))))
		                        break;
		                    p = e;
		                }
		            }
		            if (e != null) { // existing mapping for key
		                V oldValue = e.value;
		                if (!onlyIfAbsent || oldValue == null)
		                    e.value = value;
		                afterNodeAccess(e);
		                return oldValue;
		            }
		        }
		        ++modCount;   容量达到阈值扩容
		        if (++size > threshold)
		            resize();
		        afterNodeInsertion(evict);
		        return null;
		    }
		
		1、 先计算hash表是否为空，空就扩容
		2、根据key的hash值计算索引 如果tab[i]  == null直接添加一个新节点，跳到最后计算一下是否需要扩容；
		3、如果非空，判断table内第一个元素是否和key相同，相同则覆盖
		4、如果不同，则先判断是不否是树节点，如果是树节点调用：putTreeVal(this,tab,hash,key,value);
		5、不是树节点，遍历链表
		6、如果链表长度大于 TREEIFY_THREAHOLD 则树化
		7.最后检查是否需要扩容。
	
Get方法
Get --> return(e=getNode(hash(key),key))==null?null:e.value;
	getNodegetNode(inthash,Objectkey) :
		final Node<K,V> getNode(int hash, Object key) {
		        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
		        if ((tab = table) != null && (n = tab.length) > 0 &&
		            (first = tab[(n - 1) & hash]) != null) {
		            if (first.hash == hash && // always check first node
		                ((k = first.key) == key || (key != null && key.equals(k))))
		                return first;
		            if ((e = first.next) != null) {
		                if (first instanceof TreeNode)
		                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
		                do {
		                    if (e.hash == hash &&
		                        ((k = e.key) == key || (key != null && key.equals(k))))
		                        return e;
		                } while ((e = e.next) != null);
		            }
		        }
		        return null;
    }

  

