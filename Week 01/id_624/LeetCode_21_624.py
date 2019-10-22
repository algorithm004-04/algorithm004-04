#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#
# https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
#
# algorithms
# Easy (57.59%)
# Likes:    668
# Dislikes: 0
# Total Accepted:    125.8K
# Total Submissions: 217.7K
# Testcase Example:  '[1,2,4]\n[1,3,4]'
#
# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
# 
# 示例：
# 
# 输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
# 
# 
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 == None: return l2
        if l2 == None: return l1
        prev, curhead = None, None

        head = l1 if(l1.val < l2.val) else l2

        while l1 != None and l2 != None:
            if l1.val < l2.val:
                curhead = l1
                l1 = l1.next
            else:
                curhead = l2
                l2 = l2.next

            if prev != None:
                prev.next = curhead
            prev = curhead

        if l1 != None: prev.next = l1
        if l2 != None: prev.next = l2
        
        return head

# @lc code=end

