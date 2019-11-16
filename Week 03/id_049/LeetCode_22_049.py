class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def helper(s, left, right):
            if left == n and right ==n:
                res.append(s)
                return
            
            if left < n:helper(s+"(", left+1, right)
            if right < left:helper(s+")", left, right+1)
        helper("", 0, 0)
        return res
