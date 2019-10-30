class ListNode:
    def __init__(self, x):
        self.data = x
        self.next = None

    def __str__(self):
        return str(self.data)


def mergeTwoLists(l1, l2):
    prehead = ListNode(-1)
    pre = prehead

    while l1 and l2:
        if l1.data < l2.data:
            pre.next = l1
            print("l1-pre.next", pre.next)
            l1 = l1.next
            print("l1:", l1)
        else:
            pre.next = l2
            print("l2-pre.next", pre.next)
            l2 = l2.next
            print("l2:", l2)
    print(" l1:", l1, "\n", "l2:", l2)
    if l1 is not None:      # 经过画图得知，最大的Node最后会指向None，而前一个节点则会指向这个最大的节点，所以判断条件为 not None
        pre.next = l1
    else:
        pre.next = l2
    return pre.next


node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(4)

node1.next = node2
node2.next = node3
node3.next = None

node5 = ListNode(1)
node6 = ListNode(3)
node7 = ListNode(4)

node5.next = node6
node6.next = node7
node7.next = None
print(mergeTwoLists(node1, node5))
