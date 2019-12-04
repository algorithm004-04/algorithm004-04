#
# @lc app=leetcode.cn id=141 lang=python3
#
# [141] 环形链表
#
# https://leetcode-cn.com/problems/linked-list-cycle/description/
#
# algorithms
# Easy (43.52%)
# Likes:    399
# Dislikes: 0
# Total Accepted:    74K
# Total Submissions: 169.2K
# Testcase Example:  '[3,2,0,-4]\n1'
#
# 给定一个链表，判断链表中是否有环。
# 
# 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
# 
# 
# 
# 示例 1：
# 
# 输入：head = [3,2,0,-4], pos = 1
# 输出：true
# 解释：链表中有一个环，其尾部连接到第二个节点。
# 
# 
# 
# 
# 示例 2：
# 
# 输入：head = [1,2], pos = 0
# 输出：true
# 解释：链表中有一个环，其尾部连接到第一个节点。
# 
# 
# 
# 
# 示例 3：
# 
# 输入：head = [1], pos = -1
# 输出：false
# 解释：链表中没有环。
# 
# 
# 
# 
# 
# 
# 进阶：
# 
# 你能用 O(1)（即，常量）内存解决此问题吗？
# 
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 快慢指针法
    # def hasCycle(self, head: ListNode) -> bool:
    #     if head == None or head.next == None: return False
    #     fast = head.next
    #     slow = head
    #     while fast != slow:
    #         if fast == None or fast.next == None:
    #             return False
    #         fast = fast.next.next
    #         slow = slow.next
    #     return True

    # 哈希表法
    def hasCycle(self, head: ListNode) -> bool:
        if not head or not head.next: return False
        nodeSet = set([head])
        while head.next != None:
            head = head.next
            if head in nodeSet:
                return True
            else:
                nodeSet.add(head)
        return False

# @lc code=end

