# -*- coding: utf8 -*-


"""
https://leetcode-cn.com/problems/merge-two-sorted-lists/
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

"""


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def merge_two_lists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1 is not None and l2 is not None:
            prev_head = ListNode(-1)
            if l1.val <= l2.val:
                l3 = ListNode(l1.val)
                l1 = l1.next
            else:
                l3 = ListNode(l2.val)
                l2 = l2.next
            prev_head.next = l3
            while 1:
                if l1 is not None and l2 is not None:
                    if l1.val <= l2.val:
                        l3.next = ListNode(l1.val)
                        l1 = l1.next
                    else:
                        l3.next = ListNode(l2.val)
                        l2 = l2.next
                elif l1 is not None and l2 is None:
                    l3.next = ListNode(l1.val)
                    l1 = l1.next
                elif l1 is None and l2 is not None:
                    l3.next = ListNode(l2.val)
                    l2 = l2.next
                else:
                    break
                l3 = l3.next
            return prev_head.next




if __name__ == '__main__':
    l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next.next = ListNode(4)
    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)
    slt = Solution()
    l3 = slt.merge_two_lists(l1,l2)
    cur = l3
    while cur.next is not None:
        print(cur.val,end="->")
        cur = cur.next
    print(cur.val)