#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # return self.mergeTwoListIteration(l1,l2)
        return self.mergeTwoListRecursive(l1, l2)
        
    # Recursive Solution
    def mergeTwoListRecursive(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val <= l2.val:
            l1.next = self.mergeTwoListRecursive(l1.next,l2)
            return l1
        else:
            l2.next = self.mergeTwoListRecursive(l1,l2.next)
            return l2

    # Iteration Solution
    def mergeTwoListIteration(self, l1: ListNode, l2: ListNode) -> ListNode:
        prehead = ListNode(-1)
        prev = prehead
        while l1 and l2:
            if l1.val < l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next
        
        if l1 is not None:
            prev.next = l1
        else:
            prev.next = l2

        return prehead.next


        
        
# @lc code=end

