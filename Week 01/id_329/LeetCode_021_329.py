# coding=utf-8

"""
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 每次比较两个链表的val，并移动指针
    # def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
    #     pre_head = ListNode(-1)  # 精辟
    #     prev = pre_head
    #     while l1 and l2:
    #         if l1.val <= l2.val:
    #             prev.next = l1
    #             l1 = l1.next
    #         else:
    #             prev.next = l2
    #             l2 = l2.next
    #         prev = prev.next
    #     prev.next = l1 if l1 is not None else l2
    #     return pre_head.next

    # recursively
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # hack
        if not l1 or not l2:
            return l1 or l2
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
