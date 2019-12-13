class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        reversed = ''
        for i in range(0, len(s), k):
            if i // k % 2 == 0:
                piece = list(s[i:i + k])
                a, b = 0, k - 1
                if b >= len(piece): b = len(piece) - 1
                while a < b:
                    piece[a], piece[b] = piece[b], piece[a]
                    a, b = a + 1, b - 1
                reversed += ''.join(piece)
            else:
                reversed += s[i:i + k]
        return reversed


