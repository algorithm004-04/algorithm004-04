# NOTE
## 做题四件套
 - clarification -澄清问题
 - possible solutions - optimal(time & space)
 - code 
 - test cases
## 树，二叉树，二叉搜索树的实现和特性
### 树（Tree）
 - 层 level
 - 根节点 Root
 - 父节点 Parent Node
 - 子节点 Child Node
      - 左子节点，右子节点
 - 兄弟节点 Siblings  
  **链表（Linked List）是特殊化的Tree,因为有两个next指针，而链表只有一个next**
  **树是特殊化的图**

### 图(Graph)
和树的最关键差别：是否有环

## 二叉树遍历
1. 前序（Pre-order）:根-左-右
2. 中序（In-order):左-根-右
3. 后序（Post-order):左-右-根
 
## 二叉搜索树
二叉搜索树 、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree）,是指一颗空树或者具有下列性质的二叉树：
1.左子树上**所有结点**的值均小于它的根节点的值。
2.右子树上**所有结点** 的值均大于它的跟几点的值。
3.以此类推：左、右字数也分别为二叉查找树。（重复性）

### 二叉搜索树常见操作
1. 查询
2. 插入新结点（创建）
3. 删除
  时间复杂度：log(n)

**？？** 为什么树的遍历都是递归？