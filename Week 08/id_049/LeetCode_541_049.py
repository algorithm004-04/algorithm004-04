class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        n = 0
        tmp = []
        while n < len(s):
            tmp.append(s[n:n+k])
            n = n+k
        for i in range(len(tmp)):
            if i % 2 == 0:
                tmp[i] = tmp[i][::-1]
        res = ''
        for j in tmp:
            res += j
        return res