/*
 * @lc app=leetcode.cn id=141 lang=golang
 *
 * [141] 环形链表
 */

/*
// 哈希表
func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	var idx = make(map[*ListNode]bool)
	for head != nil {
		if _, ok := idx[head]; ok {
			return true
		}
		idx[head] = true
		head = head.Next
	}
	return false
}

*/

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	slow := head
	fast := head.Next
	for slow != fast {
		if fast == nil || fast.Next == nil {
			return false
		}
		slow = slow.Next
		fast = fast.Next.Next
	}
	return true
}
// @lc code=end

