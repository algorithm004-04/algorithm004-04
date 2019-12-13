class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        if not S: return S
        f = []
        for i in S:
            if i.isalpha():
                f.append(i)
        r = []
        for j in S:
            if j.isalpha():
                r.append(f.pop())
            else:
                r.append(j)
        return ''.join(r)

