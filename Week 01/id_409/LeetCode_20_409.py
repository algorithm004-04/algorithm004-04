class Solution:
    def isValid(self, s: str) -> bool:
        m = {'{': '}', '[': ']', '(': ')'}
        stack = []
        for p in s:
            if p in m:
                stack.append(p)
            elif len(stack) == 0 or m[stack.pop()] != p:
                return False
        return len(stack) == 0