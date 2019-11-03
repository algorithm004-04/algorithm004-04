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
        head = ListNode(-1)
        cursor = head
        # time O(n) space O(1)
        while (l1 != None and l2 != None):
            e1, e2 = l1.val, l2.val
            if (e1 < e2):
                cursor.next, l1 = l1, l1.next
            else:
                cursor.next, l2 = l2, l2.next
            cursor = cursor.next
        if (l1 != None):
            cursor.next = l1
        if (l2 != None):
            cursor.next = l2
        return head.next
