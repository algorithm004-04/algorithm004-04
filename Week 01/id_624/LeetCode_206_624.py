#
# @lc app=leetcode.cn id=206 lang=python3
#
# [206] 反转链表
#
# https://leetcode-cn.com/problems/reverse-linked-list/description/
#
# algorithms
# Easy (64.83%)
# Likes:    611
# Dislikes: 0
# Total Accepted:    109K
# Total Submissions: 167.5K
# Testcase Example:  '[1,2,3,4,5]'
#
# 反转一个单链表。
# 
# 示例:
# 
# 输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL
# 
# 进阶:
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
# 
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 递归法
    # def reverseList(self, head: ListNode) -> ListNode:
    #     if head == None or head.next == None: return head
    #     p = self.reverseList(head.next)
    #     head.next.next = head
    #     head.next = None
    #     return p

    # 迭代法
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        cur = head
        while cur != None:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev


# node = ListNode(1)
# node.next = ListNode(2)
# node.next.next =ListNode(3)
# node.next.next.next = ListNode(4)
# node.next.next.next.next = ListNode(5)
# print(Solution().reverseList(node))
# @lc code=end
