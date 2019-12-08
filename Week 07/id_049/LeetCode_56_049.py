class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        n = len(intervals)
        left = intervals[0][0]
        right = intervals[0][1]
        res = []
        for i in range(1, n):
            if right >= intervals[i][0]:
                if intervals[i][1] > right:
                    right = intervals[i][1]
            else:
                res.append([left, right])
                left = intervals[i][0]
                right = intervals[i][1]
        res.append([left, right])
        return res

