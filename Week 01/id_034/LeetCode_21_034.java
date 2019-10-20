/**
 * 合并两个有序的数组
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @Author blackberry
 * @Date 2019/10/17 11:17 PM
 **/
public class RemoveDuplicatesFromSortedArray {

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next();
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
