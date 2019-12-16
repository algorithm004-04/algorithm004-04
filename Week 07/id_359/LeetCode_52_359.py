class Solution(object):
    """
    个人觉得难理解的是为什么每下钻一层都要(pie | p) << 1，举个例子
    000001
    000010
    000100

    原因是为了第i层与第i-1层斜线互斥，第0层已确定最低位占了个1，接下来的每一层就必须把这个1左移
    """
    def totalNQueens(self, n):
        if n < 1:
            return 0
        self.count = 0
        self.dfs(n, 0, 0, 0, 0)
        return self.count

    def dfs(self, n, row, _col, _pie, _nai):
        if row == n:
            self.count += 1
            return
        # 取出当前层未放置1的bits
        _bits = (~(_col | _nai | _pie)) & ((1 << n) - 1)
        while _bits:
            # 取出最低位1
            pick = _bits & -_bits
            self.dfs(n, row + 1, _col | pick, (_pie | pick) << 1, (_nai | pick) >> 1)
            # 清空最低位1
            _bits &= _bits - 1