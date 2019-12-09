
 7 files changed, 100 insertions(+)
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        #print(dir(l1))
        previous = ListNode(-1)
        pre = previous
        while l1 and l2:
            if l1.val <= l2.val:
                pre.next = l1
                l1 = l1.next
            else:
                pre.next = l2
                l2 = l2.next
            pre = pre.next
        #print(dir(l1))
        pre.next = l1 if l1 is not None else l2
        return previous.next
