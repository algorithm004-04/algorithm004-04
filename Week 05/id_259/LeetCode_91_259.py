'''
91. 解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
法一：递归
有问题

class Solution(object):
    def getAns(self, s, i):
        print('********************',i)
        if len(s) <= 1:
            return len(s)
        if s[i] == '0':
            return 0
        res = 0
        res2 = 0
        # ston = list(map(int, s))

        res1 = self.getAns(s, i + 1)
        if i < len(s) - 2:
            tt = int(s[i]) * 10 + int(s[i + 1])
            if tt <= 26:
                res2 = self.getAns(s,i + 2)
        res = res1 + res2
        return res

    def numDecodings(self, s):
        return self.getAns(s, 0)
'''
'''
法二：动态规划
'''
class Solution(object):
    def numDecodings(self, s):
        if not s:
            return 0
        dp = [0 for i in range(len(s) + 1)]
        dp[0] = 1
        dp[1] = 1 if 0 < int(s[0]) <= 9 else 0
        for i in range(2, len(s) + 1):
            if 0 < int(s[i-1:i]) <= 9:
                dp[i] += dp[i-1]
            if s[i-2:i][0] != '0' and int(s[i-2:i]) <= 26:
                dp[i] += dp[i-2]
        return dp[-1]

'''
def numDecodings(self, s):
    return reduce(lambda(v,w,p),d:(w,(d>'0')*w+(9<int(p+d)<27)*v,d),s,(0,s>'',''))[1]*1

def numDecodings(self, s):
    v, w, p = 0, int(s>''), ''
    for d in s:
        v, w, p = w, (d>'0')*w + (9<int(p+d)<27)*v, d
    return w
'''

s = '226'
tmp = Solution()
print(tmp.numDecodings(s))