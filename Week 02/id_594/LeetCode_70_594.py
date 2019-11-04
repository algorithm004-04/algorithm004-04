def climbStairs(n) -> int:          # 这个递归真的太棒了吧
    res = [n] * -1
    res[0], res[1] = 1, 2
    return recursive(n , res)


def recursive(n, res):
    if res[n] == -1:
        res[n] = res[n-1, res] + res[n-2, res]
    return res[n]



ex = 5
print(climbStairs(ex))

