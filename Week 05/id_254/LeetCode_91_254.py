class Solution:
    def numDecodings(self, s: str) -> int:
      v, w, p = 0, int(s > ''), ''
      for d in s:
        v, w, p = w, (d > '0')*w + (9 < int(p+d) < 27)*v, d
      return w
