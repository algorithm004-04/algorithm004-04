from typing import List
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        board = board[0] + board[1]  # 把board连起来变一维
        moves = [(1, 3), (0, 2, 4), (1, 5), (0, 4), (1, 3, 5), (2, 4)]  # 每个位置的0可以交换的位置
        q, visited = [(tuple(board), board.index(0), 0)], set()  # bfs队列和已访问状态记录
        while q:
            state, now, step = q.pop(0)  # 分别代表当前状态，0的当前位置和当前步数
            if state == (1, 2, 3, 4, 5, 0):  # 找到了
                return step
            for next in moves[now]:  # 遍历所有可交换位置
                _state = list(state)
                _state[next], _state[now] = _state[now], state[next]  # 交换位置
                _state = tuple(_state)
                if _state not in visited:  # 确认未访问
                    q.append((_state, next, step + 1))
            visited.add(state)
        return -1


if __name__ == "__main__":
    solution = Solution()
    print(solution.slidingPuzzle([[1,2,3],[4,0,5]]))