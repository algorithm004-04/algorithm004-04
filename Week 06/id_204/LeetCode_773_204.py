class Solution(object):
    def slidingPuzzle(self, board):
        R, C = len(board), len(board[0])
        start = tuple(itertools.chain(*board))
        target = tuple(range(1, R*C) + [0])
        target_wrong = tuple(range(1, R*C-2) + [R*C-1, R*C-2, 0])
        pq = [(0, 0, start, start.index(0))]
        cost = {start: 0}

        expected = {(C*r+c+1) % (R*C) : (r, c)
                    for r in xrange(R) for c in xrange(C)}
        def heuristic(board):
            ans = 0
            for r in xrange(R):
                for c in xrange(C):
                    val = board[C*r + c]
                    if val == 0: continue
                    er, ec = expected[val]
                    ans += abs(r - er) + abs(c - ec)
            return ans

        while pq:
            #f = estimated distance (priority)
            #g = actual distance travelled (depth)
            f, g, board, zero = heapq.heappop(pq)
            if board == target: return g
            if board == target_wrong: return -1
            if f > cost[board]: continue

            for delta in (-1, 1, -C, C):
                nei = zero + delta
                if abs(zero / C - nei / C) + abs(zero % C - nei % C) != 1:
                    continue
                if 0 <= nei < R*C:
                    board2 = list(board)
                    board2[zero], board2[nei] = board2[nei], board2[zero]
                    board2t = tuple(board2)
                    ncost = g + 1 + heuristic(board2t)
                    if ncost < cost.get(board2t, float('inf')):
                        cost[board2t] = ncost
                        heapq.heappush(pq, (ncost, g+1, board2t, nei))

        return -1
