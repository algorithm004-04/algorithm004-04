#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#
# https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
#
# algorithms
# Easy (57.58%)
# Likes:    691
# Dislikes: 0
# Total Accepted:    133.8K
# Total Submissions: 230.5K
# Testcase Example:  '[1,2,4]\n[1,3,4]'
#
# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
# 
# 示例：
# 
# 输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
# 
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        start = ListNode(0)
        current = start
        while True:
            if l1.val <= l2.val:
                current.next = l1
                current = current.next
                if l1.next is None:
                    current.next = l2
                    break
                l1 = l1.next
            else:
                current.next = l2
                current = current.next
                if l2.next is None:
                    current.next = l1
                    break
                l2 = l2.next
        return start.next


        
# @lc code=end

