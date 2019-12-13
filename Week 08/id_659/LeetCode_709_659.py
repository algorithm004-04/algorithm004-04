class Solution:
    def toLowerCase(self, str: str) -> str:
        diff = ord("a") - ord("A")

        return "".join(chr(ord(c) + diff) if "A" <= c <= "Z" else c for c in str)
