class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);
        ListNode prevNode = prevHead;
        while (l1 != null && l2 != null) {
                if(l1.val <= l2.val){
                    prevHead.next = l1; 
                    l1 = l1.next;
                }else{
                    prevHead.next = l2;
                    l2 = l2.next;
                }
            prevHead = prevHead.next;
        }
        if(l1 == null){
             prevHead.next=l2;
        }else{
             prevHead.next=l1;
        }
        return prevNode.next;
    }
}