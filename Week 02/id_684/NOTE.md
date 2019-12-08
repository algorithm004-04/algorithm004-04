# NOTE


第二周课后总结


一、散列表
1、散列表的由来
1）散列表来源于数组，它借助散列表函数对数组这种数据结构进行扩展，利用的是数组支持按照下标随机访问元素的特性。
2）需要存储在散列表中的数据我们称为键，将键转化为数组下标的方法称为散列函数，散列函数的计算结构称为散列值。
3）将数据存储在散列值对应的数组下标位置。

2、如何设计散列表
总结三点设计散列函数的基本要求
1）散列函数计算得到的散列值是一个非负整数。
2）若key1=key2，则hash(key1)=hash(key2)
3）若key1 != key2，则hash(key1) != hash(key2)
正是由于第三点要求，所以产生了几乎无法避免的散列冲突问题。
3、﻿散列冲突的解决方法
﻿常用的散列 冲突解决方法有2类：开发寻址法（open addressing）和链表法（chaining）


二、二叉树，二叉搜索树
1、概念
1）什么是二叉树？
每个节点最多只有两个子节点的树，这两个节点分别是左子节点和右子节点。
2）什么是满二叉树？
有一种二叉树，除了叶子节点外，每个节点都有左右两个子节点，这种二叉树叫做满二叉树。
3）什么是完全二叉树？
有一种二叉树，叶子节点都在最底下两层，最后一层叶子节点都靠左排列，并且除了最后一层，其他层的节点个数都要达到最大，这种二叉树叫做完全二叉树。
4）什么是二叉查找树？
﻿二叉查找树要求，在树的任意一个节点，其左子树的每个节点的值都要小于这个节点的值，而右子树的节点的值都要大于这个节点的值。
﻿2、二叉树的存储
1）链式存储
每个节点有三个字段，其中一个存储数据，另外两个是指向左右节点的指针。我们只要抓住跟节点，就可以通过左右节点的指针，
把整棵树串起来。这种存储方式比较常用，大部分二叉树代码都是通过这种方式实现的。
2）顺序存储
用数组来存储，对于完全二叉树，如果节点x存储的下标为i，那么他的左子节点的存储下标为2*i，右子节点的下标为2*i+1，
反过来下标i/2存储的位置就是该节点的父节点，注意跟节点存储在下标为1的位置。完全二叉树用数组来存储时是最节省内存的方式。

﻿3、二叉树的遍历
1）前序遍历：对于树中的任意节点来说，先打印这个节点，然后打印他的左子树，最后打印它的右子树。
2）中序遍历：对于树中的任意节点来说，先打印它的左子树，然后再打印它的本身，最后打印它的右子树。
3）后序遍历：对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印它本身。
递推公式：
前序遍历：preOrder(r)=print r ->preOrder(r-left)-preOrder(r-right)
中序遍历：inOrder(r)=inOrder(r-left)->print r->inOrder(r-right)
后序遍历：postOrder(r) = postOrder(r-left)->postOrder(r-right)->print r
时间复杂度：3种遍历方式中，每个节点最多会被访问两次，所以时间复杂度是O(n)

三、递归、分治和回溯

1、为什么使用递归？递归的优缺点？
优点：代码的表达能力很强，写起来简洁。
缺点：空间复杂度高、有堆栈溢出的风险、存在重复计算、过多函数调用会耗时多等问题。
2、什么样的问题可以递归解决？
一个问题只要同事满足以下3个条件，就可以用递归来解决：
1）问题的解可以分解为几个子问题的解。何为子问题？就是数据规模更小的问题。
2）问题与子问题、除了数据规模不同，求解思路完全一样。
3）存在递归终止条件。

递归、分治和回溯代码模版

#递归模版
def recursion(level, param1, param2, ...):
    # recursion terminator 终止条件
    if level > MAX_LEVEL:
	   process_result
	   return

    # process logic in current level 逻辑层
    process(level, data...)

    # drill down
    recursion(level + 1, p1, ...)

    # reverse the current level status if needed


#分治模版
def divide_and_conquer(datas, paras):
    if exit_condition(datas): #终止条件
        return
    subData = split_data(datas)  #问题可被分解为不同的子问题
    result1 = divide_and_conquer(subdata[0], paras)
    result2 = divide_and_conquer(subdata[1], paras)
    result3 = divide_and_conquer(subdata[2], paras)
    ...
    result = mergy_data(result1, result2. result3...) #问题的结果可被还原为整体
    return result

#回溯模版
def backtracking(level, paras):
    if exist_condition(level):
        return
    state = keepsate(level)  #保存当前状态
    backtracking(level+1, paras):
    reverseState(level, state) #恢复当前状态


