//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //iteration
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         //申请一个哨兵结点，方便返回
//         ListNode prehead = new ListNode(-1);
//         //申请一个用于遍历的指针
//         ListNode prev = prehead;

//         while(l1 !=null && l2 != null) {
//             if(l1.val <= l2.val){
//                 prev.next = l1;
//                 l1 = l1.next;
//             }else{
//                 prev.next = l2;
//                 l2 = l2.next;
//             }
//             prev = prev.next;
//         }
//         prev.next = l1 == null?l2:l1;
//         //返回新链表的第一个元素结点
//         return prehead.next;
//     }

    //recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //讨论l1,l2中至少有一个为空的情况
        if (l1 ==null || l2 == null) {
            return l1 == null?l2:l1;
        }
        //讨论l1,l2都不为空的情况
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
