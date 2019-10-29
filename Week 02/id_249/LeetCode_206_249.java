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
        ListNode curr = head, prev = null;
        while ( curr != null) {
            ListNode next = curr.next;
            //1->null
            curr.next = prev;
            //prev->1
            prev = curr;
            //2->1
            curr = next;
        }
        return  prev;
    }

    //recursion
    public ListNode reverseList2(ListNode head) {
        //终止条件
        if (head == null || )
    }
}
//leetcode submit region end(Prohibit modification and deletion)
