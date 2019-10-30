def plusOne(digits):
    for i in range(len(digits)-1, -1, -1):
        if digits[i] != 9:              # 只有两种情况，一种是9，一种是非9
            digits[i] += 1              # 不等于9，只要 += 1
            return digits
        digits[i] = 0                   # 等于9，当前位置元素=0，然后判断下一位，是否等于9，是则=0，否则+1 （进位方式是重点）
    digits[0] = 1                       # 到这一步，循环结束，没有返回。代表全部都是9，整个数组已经是0，则需要扩展数组（这个思路，我没有想到耶）
    digits.append(0)
    return digits


ex = [4, 3, 2, 1]
print(plusOne(ex))
