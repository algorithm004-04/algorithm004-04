'''
85. 最大矩形
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
方法二: 动态规划 - 使用柱状图的优化暴力方法
时间复杂度 : O(N^2M)。由于需要遍历同一列中的值，计算每个点对应最大面积需要O(N)。对全部N * M个点都要计算，
             因此总共O(N) * O(NM) = O(N^2M)
空间复杂度 : O(NM)。我们分配了一个等大的数组，用于存储每个点的最大宽度。


class Solution:
    def maximalRectangle(self, matrix):
        maxarea = 0
        dp = [[0] * len(matrix[0]) for _ in range(len(matrix))]
        print('dp:{}'.format(dp))
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == '0':
                    continue
                width = dp[i][j] = dp[i][j-1] + 1 if j else 1

                for k in range(i, -1, -1):
                    width = min(width, dp[k][j])
                    maxarea = max(maxarea, width * (i - k + 1))
        return maxarea
'''
'''
方法三：使用柱状图 - 栈
复杂度分析

时间复杂度 : O(NM)。对每一行运行 力扣 84 需要 M (每行长度) 时间，运行了 N 次，共计 O(NM)。
空间复杂度 : O(M)。我们声明了长度等于列数的数组，用于存储每一行的宽度。


class Solution:
    def leetcode84(self, heights):
        stack = [-1]
        maxarea = 0
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                maxarea = max(maxarea, heights[stack.pop()] * (i - stack[-1] -1))
            stack.append(i)

        while stack[-1] != -1:
            maxarea = max(maxarea, heights[stack.pop()] * (len(heights) - stack[-1] - 1))
        return maxarea

    def maximalRectangle(self, matrix):
        if not matrix:
            return 0
        maxarea = 0
        dp = [0] * len(matrix[0])
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                dp[j] = dp[j] + 1 if matrix[i][j] == '1' else 0
            maxarea = max(maxarea, self.leetcode84(dp))
        return maxarea
'''

'''
方法四：动态规划 - 每个点的最大高度
时间复杂度 : O(NM)。每次对于N的迭代我们会对M迭代常数次。
空间复杂度 : O(M)， M 是我们保留的额外数组的长度。

class Solution:
    def maximalRectangle(self, matrix):
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        left = [0] * n
        right = [n] * n
        height =[0] * n
        maxarea = 0
        for i in range(m):
            cur_left, cur_right = 0, n
            for j in range(n):
                if matrix[i][j] == '1':
                    height[j] += 1
                else:
                    height[j] = 0
            for j in range(n):
                if matrix[i][j] == '1':
                    left[j] = max(left[j], cur_left)
                else:
                    left[j] = 0
                    cur_left = j + 1
            for j in range(n-1, -1, -1):
                if matrix[i][j] == '1':
                    right[j] = min(right[j], cur_right)
                else:
                    right[j] = n
                    cur_right = j
            for j in range(n):
                maxarea = max(maxarea, height[j] * (right[j] - left[j]))

        return maxarea
'''

'''

'''
class Solution:
    def maximalRectangle(self, maxtrix):
        if not maxtrix or not maxtrix[0]:
            return 0
        n = len(maxtrix[0])
        height = [0] * (n + 1)
        ans = 0
        for row in maxtrix:
            for i in range(n):
                height[i] = height[i] + 1 if row[i] == '1' else 0
                # print(height)
            stack = [-1]
            for i in range(n + 1):
                while height[i] < height[stack[-1]]:
                    # print(stack)
                    # print(stack[-1])
                    h = height[stack.pop()]
                    w = i - 1 - stack[-1]
                    ans = max(ans, h * w)
                stack.append(i)
        return ans




maxtrix = [["1","0","1","0","0"],
           ["1","0","1","1","1"],
           ["1","1","1","1","1"],
           ["1","0","0","1","0"]]
tmp = Solution()
print(tmp.maximalRectangle(maxtrix))
