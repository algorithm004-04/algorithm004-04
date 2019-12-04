//使用递归进行求解
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null)
            return null;
        
        head.next = removeElements(head.next,val);
        
        return head.val == val ?head.next:head;
    }
}
