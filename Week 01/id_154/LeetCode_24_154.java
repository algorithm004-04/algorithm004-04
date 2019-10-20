public class LeetCode_24_154 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head.next;
        ListNode pre = head;
        ListNode prepre = null;
        ListNode next = current.next;

        head = head.next;
        while (next != null) {
            current.next = pre;
            pre.next = next;
            if (prepre != null) {
                prepre.next = pre;
            }
            prepre = pre;
            pre = next;
            current = next.next;
            next = current.next;
        }

        current.next = pre;
        pre.next = next;

        return head;
    }
}
