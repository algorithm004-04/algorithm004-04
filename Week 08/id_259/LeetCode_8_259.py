'''
8. 字符串转换整数 (atoi)
请你来实现一个 atoi 函数，使其能将字符串转换成整数。首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到
第一个非空格的字符为止。当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。该字符串除了有效的
整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。注意：假如该字符串中的第一个非
空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。在任何情况下，若函数不
能进行有效的转换时，请返回 0。
说明：
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,2^31−1]。如果数值超过这个范围，
请返回 INT_MAX (2^31− 1) 或 INT_MIN (−2^31) 。

示例 1:
输入: "42"
输出: 42
示例 2:
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-to-integer-atoi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
'''

'''
class Solution:
    def myAtoi(self, str):
        if not str:
            return 0
        sign = 1
        base, i = 0, 0
        int_max = 2147483647
        int_min = -2147483648
        while i < len(str) and str[i] == ' ':
            i += 1
        if i >= len(str):
            return 0 

        
        if str[i] == '-' or str[i] == '+':
            sign = 1 - 2 * (str[i] == '-')
            i += 1
        
        if i < len(str) and str[i] > '0' and str[i] <= '9':
            base = int(str[i])
            i += 1
        
        while i < len(str) and str[i] >= '0' and str[i] <= '9':
            if (base > int_max // 10) or ((base == int_max // 10) and (int(str[i]) > int_max % 10)):
                if sign == 1:
                    return int_max
                else:
                    return int_min
            base = base * 10 + int(str[i])
            i += 1
        return sign * base
'''

'''
正则

import re
class Solution:
    def myAtoi(self, str):
        str = str.lstrip()
        tt = re.findall(r'(^[\-\+0]*[1-9]*\d*)\D*', str)
        # tt = re.findall(r'(^[\+\-]*\d+)\D*', str)

        print(tt)
        int_max = 2147483647
        int_min = -2147483648
        try:
            result = int(''.join(tt))
            if result > int_max :
                return int_max
            elif result < int_min :
                return int_min
            else:
                return result
        except:
            return 0
'''
class Solution:
    def myAtoi(self, str):
        str = str.lstrip()
        if len(str) == 0:
            return 0
        tmp = '0'
        result = 0
        i = 0
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        if str[0] in '+-':
            tmp = str[0]
            i += 1
        for j in range(i, len(str)):
            if str[j].isdigit():
                tmp += str[j]
            else:
                break
        if len(tmp) > 1:
            result = int(tmp)
        if result > INT_MAX > 0:
            return INT_MAX
        elif result < INT_MIN < 0:
            return INT_MIN
        else:
            return result






# str = "            09332"
# str = "words and 987"
str = "           000000000000004193 with words"

tmp = Solution()
print(tmp.myAtoi(str))


