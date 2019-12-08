'''
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    示例 1:
        输入: s = "anagram", t = "nagaram"
        输出: true
    示例 2:
        输入: s = "rat", t = "car"
        输出: false
    说明:
        你可以假设字符串只包含小写字母。
    进阶:
        如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-anagram
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''
'''
法一：排序
    将输入的字符串按字母表顺序重新排列成一个字符串，然后比较。如果给的两个字符串是字母异位词，
    那么它们重排后的字符串是相等的。
    时间复杂度：O(nlogn)
    空间复杂度：O(1)

法二：哈希表
    用一个26位的计数器，用一个计数器表计算字符串s中字符的频次，字符串t用来减少计数器表中每个字母的计数，
    最后检查计数器表是否归零，若归零，则为异位词。

法三：哈希表
    用一个26位的计数器，用一个计数器表先计算字符串s中字符，然后字符串t用来减少计数器表中每个字符的计数，
    如果在任何时候计数器低于零，说明t中出现了一个s中未出现的字符，返回false

    法二和法三：
    时间复杂度：O(n)，访问计数器表是一个固定时间的操作
    空间复杂度：O(1),因为不管字符串多长，额外需要的计数器表是固定大小的
'''

'''
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        return sorted(s) == sorted(t)

def isAnagram(s,t):
    if len(s) != len(t):
        return False
    return sorted(s) == sorted(t)

s = "rat"
t = "car"
s = 'anagram'
t = 'nagaram'
print(isAnagram(s,t))

def isAnagram(s,t):
    if len(s) != len(t):
        return False
    counter = [0] * 26
    for i in s:
        counter[ord(i) - ord('a')] += 1
        # print('counter[ord({})]:{}'.format(i,counter[ord(i) - ord('a')]))

    for i in t:
        counter[ord(i) - ord('a')] -= 1
        # print('##counter[ord({})]:{}'.format(i, counter[ord(i) - ord('a')]))
        if counter[ord(i) - ord('a')] < 0:
            return False
    return True

def isAnagram(s,t):
    if len(s) != len(t):
        return False
    dic = {}
    for i in s:
        dic[i] = dic.get(i, 0) + 1

    for i in t:
        dic[i] = dic.get(i, 0) - 1

    for i in dic:
        if dic[i] != 0:
            return False
def isAnagram(s,t):
    if len(s) != len(t):
        return False

    dic1, dic2 = {}, {}
    for item in s:
        dic1[item] = dic1.get(item, 0) + 1
    for item in t:
        dic2[item] = dic2.get(item, 0) + 1

    return dic1 == dic2
'''


def isAnagram(s, t):
    if len(s) != len(t):
        return False
    dic = {}
    for i in s:
        dic[i] = dic.get(i, 0) + 1

    for i in t:
        dic[i] = dic.get(i, 0) - 1
        if dic[i] < 0:
            return False

    return True


# s = "rat"
# t = "car"
s = 'anagram'
t = 'nagaram'
print(isAnagram(s, t))

