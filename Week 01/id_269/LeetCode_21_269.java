/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

合并两个有序链表
需要将一个链表作为基准，然后将另外一个链表上的元素移动过来。
任何一个链表到了尾部，只需要直接执行合并即可
*
*
 */
public class LeetCode_21_269 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;


        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
