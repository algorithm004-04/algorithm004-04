# DFS
def DFS_numIslands(grid: list[list[str]]):
    # 递归找 '0'(海)的坐标
    def helper(grid, i, j):
        # 为什么是在[0: len(grid))区间之外，为什么return
        if not 0 <= i < len(grid) or not 0 <= j < len(grid[0]) or grid[i][j] == '0':
            return
        grid[i][j] = '0'
        helper(grid, i+1, j)
        helper(grid, i-1, j)
        helper(grid, i, j+1)
        helper(grid, i, j-1)
    count = 0
    # 遍历二位数组，如果坐标是'1'，则横纵坐标是否被0包围，成功返回，则count+=1
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == '1':
                helper(grid, i, j)
                count += 1
    return count


# BFS
def BFS_numIslands(grid: list[list[str]]):
    def helper(grid, i, j):
        deque = [[i, j]]
        while deque:
            [i, j] = deque.pop(0)
            if not 0 <= i < len(grid) or 0 <= j < len(grid[0]) or grid[i][j] == '1':
                grid[i][j] = '0'
                deque += [[i+1, j], [i, j+1], [i-1, j], [i, j-1]]
    count = 0
    for i in range(grid):
        for j in range(grid[0]):
            if grid[i][j] == '0':
                continue
                helper(grid, i, j)
                count += 1
    return count

