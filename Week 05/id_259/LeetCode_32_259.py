'''
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
法一：暴力
在这种方法中，我们考虑给定字符串中每种可能的非空偶数长度子字符串，检查它是否是一个有效括号字符串序列。
为了检查有效性，我们使用栈的方法。

每当我们遇到一个'('，我们把它放在栈顶。对于遇到的每个‘)’ ，我们从栈中弹出一个‘(’ ，
如果栈顶没有(’，或者遍历完整个子字符串后栈中仍然有元素，那么该子字符串是无效的。
这种方法中，我们对每个偶数长度的子字符串都进行判断，并保存目前为止找到的最长的有效子字符串的长度。

时间复杂度： O(n^2)从长度为 n的字符串产生所有可能的子字符串需要的时间复杂度为 O(n^2)
             验证一个长度为 n 的子字符串需要的时间为 O(n) 。
空间复杂度： O(n)。子字符串的长度最多会需要一个深度为n的栈


class Solution(object):
    def isValid(self, s):   #判断子字符串s是否是有效的
        stack = []
        for i in range(len(s)):
            if s[i] == '(':     #'('入栈
                stack.append(s[i])
            else:   #s[i]是')'
                if stack and stack[-1] == '(':    #栈非空，且栈顶元素是'(',将栈顶元素出栈
                    stack.pop()
                else:   #其他情况，字符串无效
                    return False
        return not stack    #最后判断栈stack是否为空


    def longestValidParentheses(self, s) :
        maxlen = 0
        for i in range(len(s)): #i：从0开始，
            for j in range(i + 2, len(s) + 1, 2): #从i开始，构建偶数长度的子字符串，并判读是否为有效的
                # print('maxlen={},i={},j={}'.format(maxlen, i, j))
                if self.isValid(s[i:j]):
                    maxlen = max(maxlen, j - i)     #当前有效字符串的长度和之前最大长度比较。取最大值
        return maxlen
'''

'''
法二：动态规划
这个问题可以通过动态规划解决。我们定义一个dp 数组，其中第i个元素表示以下标为i 的字符结尾的最长有效子字符串的长度。
我们将dp 数组全部初始化为 0 。现在，很明显有效的子字符串一定以')’ 结尾。这进一步可以得出结论：以 ‘(’ 结尾的子字符串
对应的dp 数组位置上的值必定为 0 。所以说我们只需要更新 ‘)’ 在dp 数组中对应位置的值。

为了求出dp 数组，我们每两个字符检查一次，如果满足如下条件

s[i]=‘)’且s[i−1]=‘(’ ，也就是字符串形如``……()"‘‘……()"，我们可以推出：
dp[i]=dp[i−2]+2
我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2 。

s[i]=‘)’ 且 s[i−1]=‘)’，也就是字符串形如 ``.......))"‘‘.......))" ，我们可以推出：
如果s[i−dp[i−1]−1]=‘(’ ，那么
dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
这背后的原因是如果倒数第二个‘)’ 是一个有效子字符串的一部分（记为 subs），对于最后一个‘)’，
如果它是一个更长子字符串的一部分，那么它一定有一个对应的(’ ，它的位置在倒数第二个 ‘)’所在的
有效子字符串的前面（也就是 subs的前面）。因此，如果子字符串 subs的前面恰好是‘(’ ，那么我们就用2加上subs的长度
（dp[i−1]）去更新 dp[i]。除此以外，我们也会把有效子字符串 ``(,sub_s,)"之前的有效子字符串的长度也加上，
也就是加上dp[i−dp[i−1]−2] 。

时间复杂度：O(n) 。遍历整个字符串一次，就可以将 dp 数组求出来。
空间复杂度：O(n) 。需要一个大小为 n 的 dp 数组


class Solution(object):
    def longestValidParentheses(self, s):
        if len(s) < 2:
            return 0
        maxlen = 0
        dp = [0] * len(s)
        for i in range(len(s)):
            if s[i] == ')':
                #print('i={},dp[{}]={},dp[{}]={},dp[{}]={}'.format(i,i,dp[i],i-1,dp[i-1],i-2,dp[i-2]))
                if (i - 1) >=0 and s[i - 1] == '(':
                    dp[i] = 2 + (dp[i - 2] if i > 2 else 0)
                    #print('#########i={},dp[{}]={},dp[{}]={},dp[{}]={}'.format(i, i, dp[i], i - 1, dp[i - 1], i - 2, dp[i - 2]))
                elif i - dp[i - 1] > 0 and s[i - dp[i - 1] -1] == '(':
                    dp[i] = dp[i - 1] + 2 + (dp[i - dp[i - 1] - 2] if (i - dp[i - 1]) > 2 else 0)
                    #print('**********i={},dp[{}]={},dp[{}]={},dp[{}]={}'.format(i, i, dp[i], i - 1, dp[i - 1], i - 2, dp[i - 2]))
            maxlen = max(dp[i], maxlen)
        return maxlen
'''

'''
法三：栈
我们可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的子字符串的有效性，同时保存目前最长有效字符串的长度。
我们首先将 -1放入栈顶。对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。对于遇到的每个‘)’，我们弹出栈顶的元素
然后将当前元素的下标与栈顶元素下标作差，得出当前有效括号字符串的长度。通过这种方法，我们继续计算有效子字符串的长度，
并最终返回最长有效子字符串的长度。
时间复杂度：O(n) 。遍历整个字符串一次，就可以将最大长度求出来。
空间复杂度：O(n) 。需要一个大小为 n 的 栈

class Solution(object):
    def longestValidParentheses(self, s):
        maxlen = 0
        stack = []
        stack.append(-1)
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack: #栈为空，把当前元素的下标压入栈
                    stack.append(i)
                else:
                    maxlen = max(maxlen, i - stack[-1])
        return maxlen
'''

'''
法四：两个计数器
在这种方法中，我们利用两个计数器 left 和 right。首先，我们从左到右遍历字符串，对于遇到的每个‘(’，
我们增加 left 计算器，对于遇到的每个‘)’ ，我们增加 right 计数器。每当 left 计数器与 right 计数器相等时，
我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。如果 right 计数器比 left 计数器大时，
我们将 left 和 right 计数器同时变回 0 。
接下来，我们从右到左做一遍类似的工作。

时间复杂度：O(n) 。遍历整个字符串一次，就可以将最大长度求出来。
空间复杂度：O(1) 。只需要两个额外的变量left和right
'''
class Solution(object):
    def longestValidParentheses(self, s):
        maxlen = 0

        left, right = 0, 0
        for i in range(len(s)):
            if s[i] == '(':
                left += 1
            else:
                right += 1
            print('left={},right={},maxlen={}'.format(left, right, maxlen))

            if left == right:
                maxlen = max(maxlen, 2 * right)
            elif right > left:
                left = right = 0

        left = right = 0
        for i in range(len(s)-1, -1, -1):
            if s[i] == '(':
                left += 1
            else:
                right += 1
            print('***left={},right={},maxlen={}'.format(left, right, maxlen))

            if left == right:
                maxlen = max(maxlen, 2 * left)
            elif left > right:
                left = right = 0

        return maxlen



# s = "(()()(()("
# s = "((())"
# s = "()()"
s = "(()()())))()()"
tmp = Solution()
print(tmp.longestValidParentheses(s))