class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def detectCycle(self, head):        # 快慢指针
        fast, slow = head, head
        while True:
            if not (fast and fast.next):
                return False
            fast = fast.next.next       # 原代码：fast = fast.next 结果fast和slow步数一样，永远无法相同。
            slow = slow.next            # 第二个循环之所以一样，是需要判断出fast距离入口的距离
            if fast == slow:
                break
        fast = head
        while fast != slow:
            fast = fast.next
            slow = slow.next
        return fast
