//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
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
    public ListNode reverseList(ListNode head) {
        //curr指向头结点
        ListNode curr = head;
        //prev指向空指针
        ListNode prev = null;
        while (curr != null) {
            //保存当前节点的下一个节点
            ListNode next = curr.next;
            //将当前节点指向前一个结点
            curr.next = prev;
            //prev指向当前节点
            prev = curr;
            //当前节点指向下一个节点
            curr = next;
        }
    }
    //recursion:还需研究
//    public ListNode reverseList(ListNode head) {
//        //只有一个元素
//        if (head == null || head.next == null) return head;
//        //1->2->null => null->2->1
//        ListNode p = reverseList(head.next);
//        //将
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
