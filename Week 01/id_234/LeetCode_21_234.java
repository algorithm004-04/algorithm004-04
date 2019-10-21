class Solution {
    // 双指针 T:O(m+n) S:O(1)
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode preNode = new ListNode(-1);
    ListNode pre = preNode;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
    }
    pre.next = l1 == null ? l2 : l1;
    return preNode.next;
  }
}
