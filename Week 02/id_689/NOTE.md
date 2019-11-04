# 第二周学习笔记
#### 哈希表
- 哈希算法
  - 根据设定的哈希函数H（key）和处理冲突方法将一组关键字映象到一个有限的地址区间上的算法。
- 哈希表
  - 数据经过哈希算法之后得到的集合。这样关键字和数据在集合中的位置存在一定的关系，可以根据这种关系快速查询。
- 哈希冲突
  - 由于哈希算法被计算的数据是无限的，而计算后的结果范围有限，因此总会存在不同的数据经过计算后得到的值相同，这就是哈希冲突。
  - 解决哈希冲突的方法
    - 开放定址法
      - 从发生冲突的那个单元起，按照一定的次序，从哈希表中找到一个空闲的单元。然后把发生冲突的元素存入到该单元的一种方法。
    - 拉链法
      - 链接地址法的思路是将哈希值相同的元素构成一个同义词的单链表，并将单链表的头指针存放在哈希表的第i个单元中，查找、插入和删除主要在同义词链表中进行。
#### 递归
- 定义
  - 递归(Recursion)是指在函数的定义中使用函数自身的方法。
- 思想
  - 递归就是有去有回。“有去”是指：递归问题必须可以分解为若干个规模较小，与原问题形式相同的子问题，这些子问题可以用相同的解题思路来解决，“有回”是指 : 这些问题的演化过程是一个从大到小，由近及远的过程，并且会有一个明确的终点(临界点)，一旦到达了这个临界点，就不用再往更小、更远的地方走下去。最后，从这个临界点开始，原路返回到原点，原问题解决。
  - 递归的基本思想就是把规模大的问题转化为规模小的相似的子问题来解决。特别地，在函数实现时，因为解决大问题的方法和解决小问题的方法往往是同一个方法，所以就产生了函数调用它自身的情况，这也正是递归的定义所在。格外重要的是，这个解决问题的函数必须有明确的结束条件，否则就会导致无限递归的情况。
- 递归的三要素
  - 明确递归终止条件；
  - 给出递归终止时的处理办法；
  - 提取重复的逻辑，缩小问题规模。
- 递归模板
    - 泛型递归
        ```java
        public void recur(int level, int param) {
             // terminator
        if (level > MAX_LEVEL) { // process result
        return; }
             // process current logic
             process(level, param);
             // drill down
             recur( level: level + 1, newParam);
             // restore current status
        }
        ```
     - 分治
        ```python
       def divide_conquer(problem, param1, param2, ...): 
       # recursion terminator
       if problem is None:
           print_result
       return
       # prepare data
       data = prepare_data(problem)
       subproblems = split_problem(problem, data)
       # conquer subproblems
       subresult1 = self.divide_conquer(subproblems[0], p1, ...)
       subresult2 = self.divide_conquer(subproblems[1], p1, ...)
       subresult3 = self.divide_conquer(subproblems[2], p1, ...)
       ...
       # process and generate the final result
       result = process_result(subresult1, subresult2, subresult3, ...)
       # revert the current level states
        ```

  

