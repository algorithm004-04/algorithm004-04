//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if(l1.val <= l2.val) {
            //l1链表头作为合并后的头结点
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }

        if(l2.val < l1.val) {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }


        return null;
    }
}


//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        ListNode preHead = new ListNode(-1);
//        ListNode head = preHead;
//        while (l1 != null && l2 != null) {
//            if(l1.val <= l2.val) {
//                preHead.next = l1;
//                l1 = l1.next;
//            }else {
//                preHead.next = l2;
//                l2 = l2.next;
//            }
//            preHead = preHead.next;
//        }
//
//        preHead.next = l1 == null ? l2 : l1;
//
//        return head.next;
//
//    }

//1.递归
//2.迭代