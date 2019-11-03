#
# @lc app=leetcode.cn id=25 lang=python3
#
# [25] K 个一组翻转链表
#
# https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
#
# algorithms
# Hard (54.65%)
# Likes:    282
# Dislikes: 0
# Total Accepted:    24.2K
# Total Submissions: 44.2K
# Testcase Example:  '[1,2,3,4,5]\n2'
#
# 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
# 
# k 是一个正整数，它的值小于或等于链表的长度。
# 
# 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
# 
# 示例 :
# 
# 给定这个链表：1->2->3->4->5
# 
# 当 k = 2 时，应当返回: 2->1->4->3->5
# 
# 当 k = 3 时，应当返回: 3->2->1->4->5
# 
# 说明 :
# 
# 
# 你的算法只能使用常数的额外空间。
# 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        remain = 0
        cur = head
        # 统计接下来是否有k个节点供翻转
        while cur != None and remain != k:
            remain += 1
            cur = cur.next
        # 如果不足k个就不需要翻转，直接返回头节点
        if remain < k: return head
        # 翻转k个节点
        cur = self.reverseKGroup(cur, k) 
        # cur - 已经翻转好的部分的头节点
        # head - 尚未翻转的部分的头节点
        while remain > 0: 
            # 保存下一个元素
            temp = head.next
            # 将尚未翻转的头节点指向已翻转的头节点
            head.next = cur
            # 已翻转的头节点更新
            cur = head
            # 未翻转的头节点更新
            head = temp
            # 本轮剩余翻转数减1
            remain -= 1
        return cur


# @lc code=end

