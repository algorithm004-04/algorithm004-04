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

// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class LeetCode_206_154 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while (currentNode.next != null) {
            nextNode = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = nextNode;
        }

        currentNode.next = pre;

        return currentNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
