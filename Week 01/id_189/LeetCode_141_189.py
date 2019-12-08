#
# @lc app=leetcode.cn id=141 lang=python
#
# [141] 环形链表
#

# 1. 暴力法, 保存一个列表。
# 2019.10.20 通过。


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# class Solution(object):
#     def hasCycle(self, head):
#         """
#         :type head: ListNode
#         :rtype: bool
#         """

#         tmp_list = []

        # while head is not None:
        #     if head in tmp_list: 
        #         return True
        #     tmp_list.append(head)
        #     head.next

#         return False

# 2. 快慢指针。参考高分评论。
# 2019.10.20 通过。

# @lc code=start

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast: return True

        return False

# @lc code=end

