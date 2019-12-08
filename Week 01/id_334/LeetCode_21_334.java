package Array;
//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//
// Related Topics Linked List

// 第一个想法V1：链表遍历常见的就是递归，这里就是谁大拼接到谁后面
//              时间复杂度o(m+n) 空间复杂度o(m+n)-递归

// 第二个想法V2：正常迭代，引入哨兵元素充当临时节点作为上一次的结果，要么是pre，要么是next，要么两个都有
//              时间复杂度o(m+n) 空间复杂度o(1)

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class LeetCode_21_334 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode r = mergeTwoListsV2(listNode1, listNode4);
        List list = new ArrayList();
        while (r != null) {
            list.add(r.val);
            r = r.next;
        }
        System.out.println(list);
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     Memory Usage: 39.3 MB, less than 17.85% of Java online submissions for Merge Two Sorted Lists.
     */
    public static ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsV1(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoListsV1(l1, l2.next);
        return l2;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     Memory Usage: 39.5 MB, less than 16.84% of Java online submissions for Merge Two Sorted Lists.
     */
    public static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        //之前的判断条件决定了 l1和l2其中一个会先为空，因此需要补充最后一位（有序情况下最大值肯定是最后一位）
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
