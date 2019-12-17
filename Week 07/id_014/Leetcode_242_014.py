'''
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
'''

# Solution 1: use dictionary
class Solution:
    def isAnagram(self, s:str, t:str) -> bool:
        if len(s) != len(t):
            return False
        count = {}
        for i in range(len(s)):
            count[s[i]] = count[s[i]]+1 if s[i] in count else 1
            count[t[i]] = count[t[i]]-1 if t[i] in count else -1
        return not any(count.values())

# Solution 2: use list
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        count = [0] * 26
        for ch1, ch2 in zip(s, t):
            count[ord(ch1)-ord('a')] += 1 
            count[ord(ch2)-ord('a')] -= 1
        return not any(count)
        