#
# @lc app=leetcode.cn id=21 lang=python
#
# [21] 合并两个有序链表
#

# 1. 抄答案

# @lc code=start
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        prehead = ListNode(-1)

        prev = prehead

        while l1 and l2:
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2. next
            prev = prev.next

        prev.next = l1 if l1 is not None else l2

        return prehead.next

        
# @lc code=end

