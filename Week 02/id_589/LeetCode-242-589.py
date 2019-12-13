#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return self.isAnagram2(s,t)

    # Solution1: sorted the array and compare counts
    def isAnagram1(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)

    # Solution2: 
    # Customize a simpele hash table
    # Use `a-z` as key to compare counts 
    # Only for ASCII code string
    def isAnagram2(self, s: str, t: str) -> bool:
        dict1, dict2 = [0]*26, [0]*26
        for item in s:
            dict1[ord(item) - ord('a')] += 1
        for item in t:
            dict2[ord(item) - ord('a')] += 1
        return dict1 == dict2

    # Solution3:
    # Use dictionary and compare counts
    def isAnagram3(self, s: str, t: str) -> bool:
        dict1, dict2 = {}, {}
        for item in s:
            dict1[item] = dict1.get(item, 0) + 1
        for item in t:
            dict2[item] = dict2.get(item, 0) + 1
        return dict1 == dict2
        
        

        
# @lc code=end

