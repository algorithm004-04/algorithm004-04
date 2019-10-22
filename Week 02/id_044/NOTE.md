# NOTE
1.关于HashMap有几个前提先说清楚，要不然后面看代码的时候也是懵的(以JDK1.8为例来说明)
    (1).HashMap继承(extends)自 AbstractMap<K,V>抽象(abstract)类 实现(implements)了Map<K,V>,Cloneable, Serializable三个接口
    (2).DEFAULT_INITIAL_CAPACITY = 1 << 4;初始容量为1*2*2*2*2=16(左移1位就是乘以2，左移4位就是乘以2^4)。MAXIMUM_CAPACITY = 1 << 30;最大容量为(2^30)
    (3).DEFAULT_LOAD_FACTOR = 0.75f;初始加载因子，容量*加载因子=阀值，如果添加的元素大于这个阀值，就两倍扩容
    (4).TREEIFY_THRESHOLD = 8;这个变量我的理解为，如果一个Key对应的Hash表中的元素超过8个，就转换为树(这里转换为红黑树)，在后面还有一个值决定是不是转换为树
    (5).UNTREEIFY_THRESHOLD = 6;如果一个Key对应的Hash表中的元素小于6个，如果元素结构是红黑树的话，就转换为单链表结构
    (6).MIN_TREEIFY_CAPACITY = 64;这个变量在treeifyBin这个方法中，只有HashMap中的元素大于64才会去真正的转换为红黑树
    (7).Node<K,V>为HashMap中没有树型化时的类型，TreeNode<K,V>为树型化后的类型(1.8之前没有转红黑树的操作，直接是用的Entry<K,V>的单链表)

2.把有关前提说完后，开始来介绍里面两个有代表性的方法put(K,V);get(K)。为了能更清楚的说明，我就直接贴代码，然后写注释
    (1)put(K,V)方法：
    
    public V put(K key, V value) {
        //调用putVal方法
        return putVal(hash(key), key, value, false, true);
    }
    
    来看看putVal方法
    hash把key求hash值;key和value分别是键值对，onlyIfAbsent如果里的值已存在，则不去覆盖原来的值，evict我也没太看懂这是干嘛的，影响不大
    
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            //如果第一次调用put方法，table为空，调用resize()方法，一个初始化和扩容的方法，后面再分析具体的实现
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            //在指定tab数组的位置没有值的话，把新加的值添加到数组指定位置(相当于存Key的位置没有值)
            tab[i] = newNode(hash, key, value, null);
        else {
            //在指定tab数组的位置已经存在值了，那么把新加的值存到已存在的Key对应的值最后
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                //如果新添加的值和已存在的Key相同，让e = p;
                e = p;
            else if (p instanceof TreeNode)
                //如果添加的元素是红黑树，则调用TreeNode里面相关的put方法。这里我就不去详情说了，太复杂了，我也没看懂
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                //Key对应的节点数量
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        //如果是最后一个，把新添加的元素加到最后一个元素后面
                        p.next = newNode(hash, key, value, null);
                        //如果节点元素大于TREEIFY_THRESHOLD-1这个值，调用转红黑树的方法
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        //如果新添加的值和节点的元素中相同，直接跳出不处理
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                //如果存在相同的元素，onlyIfAbsent这个值为true，就不去覆盖原值
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        //修改次数加1
        ++modCount;
        //size>阀值就会触发扩容，增加两倍
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    (2)resize()方法:
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        //得到原来tab的容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //原来的阀值
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            //如果原容量不为0
            if (oldCap >= MAXIMUM_CAPACITY) {
                //原容量大于最大容量，把阀值设置为int能表示的最大值
                //不再继续扩容，把原tab返回
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                //如果新容量扩容2倍后，小于最大容量，且原容量大于初始化容量
                //阀值扩容2倍
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            //如果阀值和容量都为0，都取默认值
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            //如果阀值没有设置，则为新容量*加载因子
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        //把新的阀值赋值给阀值变量
        threshold = newThr;
        //新建一个newCap长度的Node<K,V>[]数组
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        //把新tab赋值给table
        table = newTab;
        //如果原tab有值，扩容之后把原来的元素都放到新的tab数组中去
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        //返回新扩容的数组
        return newTab;
    }
    (3)treeifyBin()这个方法再提一下，注意第二行(n = tab.length) < MIN_TREEIFY_CAPACITY这个条件，只有tab的元素大于等于64的时候，才真正的转红黑树
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }

    (4)get(key)方法:
    public V get(Object key) {
        Node<K,V> e;
        //调用了getNode(hash,key)方法
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
    (5)getNode(hash,key)方法：
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            //数组不为空，长度不为0，在数组中能找到key对应的元素，则继续
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                //如果找到的元素刚好是key对应的这个元素，直接返回
                return first;
            if ((e = first.next) != null) {
                //如果第一个元素后面还有元素
                if (first instanceof TreeNode)
                //如果第一个元素是红黑树，则去对应的TreeNode方法中去找
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                //如果不是红黑树，则循环这个单链表
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

3.HashMap的源码就分析到这，如果有不准确的地方，欢迎指出，如果有问题的话，也欢迎随时一起探讨
  

