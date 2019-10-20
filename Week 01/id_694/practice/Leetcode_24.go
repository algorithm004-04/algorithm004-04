/*
 * @lc app=leetcode.cn id=24 lang=golang
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	pre := new(ListNode)
	pre.Next = head
	tmp := pre
	for tmp.Next != nil && tmp.Next.Next != nil {
		start := tmp.Next
		end := tmp.Next.Next
		tmp.Next = end
		start.Next = end.Next
		end.Next = start
		tmp = start
	}
	return pre.Next
}
// @lc code=end

