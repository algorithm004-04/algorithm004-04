#
# @lc app=leetcode.cn id=433 lang=python3
#
# [433] 最小基因变化
#
# https://leetcode-cn.com/problems/minimum-genetic-mutation/description/
#
# algorithms
# Medium (43.73%)
# Likes:    17
# Dislikes: 0
# Total Accepted:    1K
# Total Submissions: 2.3K
# Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
#
# 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
# 
# 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
# 
# 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
# 
# 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
# 
# 现在给定3个参数 — start, end,
# bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
# 
# 注意:
# 
# 
# 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
# 所有的目标基因序列必须是合法的。
# 假定起始基因序列与目标基因序列是不一样的。
# 
# 
# 示例 1:
# 
# 
# start: "AACCGGTT"
# end:   "AACCGGTA"
# bank: ["AACCGGTA"]
# 
# 返回值: 1
# 
# 
# 示例 2:
# 
# 
# start: "AACCGGTT"
# end:   "AAACGGTA"
# bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
# 
# 返回值: 2
# 
# 
# 示例 3:
# 
# 
# start: "AAAAACCC"
# end:   "AACCCCCC"
# bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
# 
# 返回值: 3
# 
# 
#

# @lc code=start

from collections import deque

class Solution:
    # 思路：BFS
    def minMutation(self, start: str, end: str, bank: [str]) -> int:
        def available(lv: str, rv: str) -> bool:
            flag = 0
            for i in range(len(lv)):
                if lv[i] != rv[i]: flag += 1
                if flag > 1: break
            return flag == 1
        # count:统计寻找的次数
        # cur：当前的基因序列
        # prev：层前一个序列，为了在寻找下一个序列时不要找回上一序列
        queue = deque([[start, start, 0]])
        while queue:
            prev, cur, count = queue.popleft()
            if cur == end: return count
            for string in bank:
                if available(cur, string) and string != prev:
                    queue.append([cur, string, count+1])

        

        return -1

# print(Solution().minMutation("AACCGGTT", "AACCGGTA", ["AACCGGTA"]))
print("1" + "3")
# @lc code=end

