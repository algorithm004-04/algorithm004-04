class Solution:
    def firstUniqChar(self, s):
        obj, min = {}, len(s)
        for i, j in enumerate(s):
            if j in obj:
                obj[j].append(i)
            else:
                obj.setdefault(j, [i])
        for i in obj:
            if len(obj[i]) == 1:
                min = obj[i][0] if obj[i][0] < min else min
        if min == len(s):
            return -1
        return min

solution = Solution()
min = solution.firstUniqChar(str)
print(min)