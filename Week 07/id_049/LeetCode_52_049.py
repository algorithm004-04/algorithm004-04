class Solution:
    def totalNQueens(self, n: int) -> int:
        if n < 1:return 0
        self.count = 0
        self.dfs(n, 0, 0, 0, 0)
        return self.count

    def dfs(self, n, row, cols, pie, na):
        if row >= n:
            self.count += 1
            return
        bits = (~(cols|pie|na)) & ((1 << n) -1)
        while bits > 0:
            p = bits & -bits
            self.dfs(n, row+1, cols|p, (pie|p)>>1, (na|p)<<1)
            bits = bits & (bits - 1)