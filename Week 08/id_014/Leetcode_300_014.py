"""
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
"""

# Solution 1: DP
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        dp = [1] * len(nums)
        max_len = 1
        
        for i, n in enumerate(nums):
            for j, m in enumerate(nums[:i]):
                if m < n:
                    dp[i] = max(dp[i], dp[j]+1)
                    max_len = max(max_len, dp[i])
                    
        return max_len

# Solution 2: Binary Search
