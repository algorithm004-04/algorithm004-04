#将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
#
# 示例： 
#
# 输入：1->2->4, 1->3->4
#输出：1->1->2->3->4->4
# 
# Related Topics 链表



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
        
#leetcode submit region end(Prohibit modification and deletion)

s = Solution()

Node1 = ListNode(1)
Node2 = ListNode(2)
Node3 = ListNode(0)
Node4 = ListNode(3)
Node5 = ListNode(4)
Node6 = ListNode(7)

Node1.next = Node2
Node2.next = None

Node3.next = Node4
Node4.next = Node5
Node5.next = Node6
Node6.next = None

print(s.mergeTwoLists(Node1, Node3))