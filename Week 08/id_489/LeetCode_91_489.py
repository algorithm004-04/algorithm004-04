class Solution:
    def numDecodings(self, s: str) -> int:
        n=len(s)
        if(not s or s[0]=="0"):
            return 0
        pre=1
        cur=1
        for i in range(1,n):
            if(s[i]=="0"):
                if(s[i-1]=="1" or s[i-1]=="2"):
                    cur=pre
                else:
                    return 0
            else:
                if(s[i-1]=="1" or (s[i-1]=="2" and "1"<=s[i]<="6")):
                    tmp=cur
                    cur+=pre
                    pre=tmp
                else:
                    pre=cur
                    cur=cur
        return cur


if __name__ == "__main__":
    solution = Solution()
    print(solution.numDecodings('12'))