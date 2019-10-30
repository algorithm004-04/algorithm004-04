class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def hasCycle(head):     # 双指针
        if head is None:
            return False
        slow = head
        fast = head.next
        while fast.next and fast.next:          # 原句 while fast.next and fast.next.next:  但会报错类型错误，应该是fast.next.next在只有一个节点的时候，会出现类型错误
            fast = fast.next.next
            slow = slow.next
            if slow == fast:
                return True
        return False


