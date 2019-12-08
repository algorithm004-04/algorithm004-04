/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null != l2) {
            return l2;
        } else if (null != l1 && null == l2) {
            return l1;
        } else if (null == l1 && null == l2) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode min = head;

        while (true) {
            if (l1.val <= l2.val) {
                min.next = l1;
                if (null != l1.next) {
                    l1 = l1.next;
                } else {
                    l1.next = l2;
                    break;
                }
            } else {
                min.next = l2;
                if (null != l2.next) {
                    l2 = l2.next;
                } else {
                    l2.next = l1;
                    break;
                }
            }

            min = min.next;
        }

        return head.next;
    }
}