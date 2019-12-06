'''
72. 编辑距离
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

示例 1:
输入: word1 = "horse", word2 = "ros"
输出: 3
解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2:
输入: word1 = "intention", word2 = "execution"
输出: 5
解释:
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
法一：动态规划
我们的目的是让问题简单化，比如说两个单词 horse 和 ros 计算他们之间的编辑距离 D，容易发现，
如果把单词变短会让这个问题变得简单，很自然的想到用 D[n][m] 表示输入单词长度为 n 和 m 的编辑距离。
具体来说，D[i][j] 表示 word1 的前 i 个字母和 word2 的前 j 个字母之间的编辑距离。
当我们获得 D[i-1][j]，D[i][j-1] 和 D[i-1][j-1] 的值之后就可以计算出 D[i][j]。
每次只可以往单个或者两个字符串中插入一个字符，那么递推公式很显然了
如果两个子串的最后一个字母相同，word1[i] = word2[i] 的情况下：
D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1]−1)

时间复杂度 ：O(mn)，两层循环显而易见。
空间复杂度 ：O(mn)，循环的每一步都要记录结果。

class Solution(object):
    def minDistance(self, word1, word2):
        m = len(word1)
        n = len(word2)
        # print(m,n)
        if m * n == 0: #word1或者word2长度为零,即某个字符串为空
            return m + n

        ds = [[0 for i in range(n + 1)] for j in range(m + 1)] #m行n列的二维列表
        # print(ds)
        for i in range(m + 1):
            ds[i][0] = i
        for j in range(n + 1):
            ds[0][j] = j
        print("***************")
        for i in range(1, m + 1):
            print("***************")
            for j in range(1, n + 1):
                left = ds[i - 1][j] + 1
                down = ds[i][j - 1] + 1
                left_down = ds[i - 1][j - 1]
                if word1[i - 1] != word2[j - 1]:
                    left_down += 1
                ds[i][j] = min(left, down, left_down)
                print('ds[{}][{}]={}'.format(i,j,ds[i][j]))
                # print(ds)
        print('ds=',ds)
        return ds[m][n]
'''
'''
法二：法一优化
时间复杂度 ：O(mn)，两层循环显而易见。
空间复杂度 ：O(n)

class Solution(object):
    def minDistance(self, word1, word2):
        m, n = len(word1), len(word2)
        if m * n == 0:
            return m + n
        cur = [i for i in range(n + 1)]
        for i in range(1, m + 1):
            pre = cur[0]
            cur[0] = i
            for j in range(1, n + 1):
                tmp = cur[j]
                if word1[i - 1] == word2[j - 1]:
                    cur[j] = pre
                else:
                    cur[j] = 1 + min(pre, cur[j], cur[j - 1])
                pre = tmp
        return cur[n]
'''
class Solution(object):
    def minDistance(self, word1, word2):
        m, n = len(word1), len(word2)
        if m * n == 0:
            return m + n
        pre = [i for i in range(n + 1)]
        print(pre)
        for i in range(1, m + 1):
            cur = [i] * (n + 1)
            print('*************************')
            for j in range(1, n + 1):
                cur[j] = min(pre[j] + 1, cur[j - 1] + 1, pre[j - 1] + (word1[i - 1] != word2[j - 1]))
                print('cur[{}]={}'.format(j, cur[j]))
            pre = cur[:]
            print(cur)
            print(pre)
        return pre[-1]
        # l1, l2 = len(word1) + 1, len(word2) + 1
        # pre = [0 for _ in range(l2)]
        # for j in range(l2):
        #     pre[j] = j
        # print(pre)
        # for i in range(1, l1):
        #     cur = [i] * l2
        #     print('*************************')
        #     for j in range(1, l2):
        #         cur[j] = min(cur[j - 1] + 1, pre[j] + 1, pre[j - 1] + (word1[i - 1] != word2[j - 1]))
        #         print('cur[{}]={}'.format(j, cur))
        #     pre = cur[:]
        # return pre[-1]



word1 = "horse"
word2 = "ros"
# word1 = "h"
# word2 = "r"
tmp = Solution()
print(tmp.minDistance(word1, word2))


