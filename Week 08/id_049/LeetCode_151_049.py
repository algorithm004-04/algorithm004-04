class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        tmp = []
        for i in s.split(" "):
            if i != "":
                tmp.append(i)
        tmp.reverse()
        return " ".join(tmp)