class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
# iteratively
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        cur1, cur2 = l1, l2
        new = ListNode(0)
        cur = new
        while cur1 != None and cur2 != None:
            # print(cur1.val)
            # print(cur2.val)
            if cur1.val <= cur2.val:
                cur.next = cur1
                cur1 = cur1.next
            else:
                cur.next = cur2
                cur2 = cur2.next
            cur = cur.next
        if cur1 != None:
            cur.next = cur1

        if cur2 != None:
            cur.next = cur2

        return new.next

    # recursively
    def MergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 or not l2:
            return l1 or l2
        if l1.val < l2.val:
            l1.next = self.recursionMergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.recursionMergeTwoLists(l1, l2.next)
            return l2