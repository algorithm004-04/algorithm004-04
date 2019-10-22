#
# @lc app=leetcode.cn id=24 lang=python3
#
# [24] 两两交换链表中的节点
#
# https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
#
# algorithms
# Medium (62.46%)
# Likes:    308
# Dislikes: 0
# Total Accepted:    46.2K
# Total Submissions: 73.9K
# Testcase Example:  '[1,2,3,4]'
#
# 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
# 
# 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
# 
# 
# 
# 示例:
# 
# 给定 1->2->3->4, 你应该返回 2->1->4->3.
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
    # 递归解法：递归需要考虑三个问题：
    # 1. 终止条件
    # 2. 调用单元要做的事情
    # 3. 返回值
    # 对于本题来说，
    # - 调用单元要做的事情就是将当前元素的下一元素指向已经交换好的后面的元素，并将当前元素的下一个元素的下一个元素指向当前元素，即
    #      对于1，2，3，4来说，让1指向2之后交换好的元素，让2指向1即可
    # - 返回值应该是当前元素的下一元素，因为经过交换之后，当前元素的下一元素就是已经交换过的元素的头部
    # - 终止条件则是head或head.next 为none，因为当head或head.next为none时，对于当前head来说，剩下的元素都是翻转好的了。

    def swapPairs(self, head: ListNode) -> ListNode:
            if head == None or head.next == None: return head
            next = head.next
            head.next = self.swapPairs(next.next)
            next.next = head
            return next
        
# @lc code=end

