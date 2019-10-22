package week01;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 归并法
 * 分别取两个链表第一个元素比较，较小的进最终的链表
 * 定义一个head节点，用来表示最终链表的头
 * 时间复杂度O(m+n)
 * 空间复杂度O(1)
 *
 */
public class LeetCode_21_294 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //定义一个头结点，不然需要比较l1和l2的首个元素，取较小的作为头
        ListNode cursor = new ListNode(0);
        ListNode head = cursor;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                cursor.next = l1;
                l1 = l1.next;
                cursor = cursor.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                cursor.next = l2;
                l2 = l2.next;
                cursor = cursor.next;
            }
        }

        return head.next; //这里舍弃了自定义的head节点
    }
}
