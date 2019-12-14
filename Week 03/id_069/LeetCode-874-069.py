# 20191103

# Done

"""
    机器人在一个二维的空间内行走，每次走动得到的是一个xy坐标
    1. 得到command所对应的方向
    2. 每走一步判断是否走到障碍物，没有遇到障碍物则继续走，遇到则退出计算当前行走的距离
"""
class Solution:
    def robotSim(self, commands, obstacles):
        i = j = mx = d = 0
        move, obstacles = [(0, 1), (-1, 0), (0, -1), (1, 0), ], set(map(tuple, obstacles))
        for command in commands:
            if command == -2:
                d = (d + 1) % 4
            elif command == -1:
                d = (d - 1) % 4
            else:
                x, y = move[d]
                while command and (i + x, j + y) not in obstacles:
                    i += x
                    j += y
                    command -= 1
            mx = max(mx, i**2 + j**2)
        return mx


    
