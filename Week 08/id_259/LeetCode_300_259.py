'''
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''
'''
暴力：
时间复杂度：O(N**2)
空间复杂度：O(N)

class Solution:
    def longOfLIS(self, nums):
        maxlen = 0
        # i = 0
        leng = []
        length = 1

        for pre in range(len(nums)):
            i = pre
            for last in range(pre + 1, len(nums)):
                if nums[i] < nums[last]:
                    length += 1
                    i = last
                else:
                    continue
            leng += [length]
            length = 1
        # print(leng)
        maxlen = max(leng)
        return maxlen
'''
'''
tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6

class Solution:
    def longOfLIS(self, nums):
        tails, res = [0] * len(nums), 0

        for num in nums:
            i, j = 0, res
            while i < j:
                m = (i + j) // 2
                if tails[m] < num:
                    i = m + 1
                else:
                    j = m
            tails[i] = num
            if j == res:
                res += 1
        return res
'''
'''
'''
class Solution:
    def longOfLIS(self, nums):
        def binarySearch(sub, val):
            lo, hi = 0, len(sub) - 1
            while (lo <= hi):
                mid = lo + (hi - lo) // 2
                if sub[mid] < val:
                    lo = mid + 1
                elif sub[mid] > val:
                    hi = mid - 1
                else:
                    return mid
            return lo

        sub = []
        for val in nums:
            pos = binarySearch(sub, val)
            if pos == len(sub):
                sub.append(val)
            else:
                sub[pos] = val
        return len(sub)





nums = [10,9,2,5,3,7,101,18]
tmp = Solution()
print(tmp.longOfLIS(nums))
