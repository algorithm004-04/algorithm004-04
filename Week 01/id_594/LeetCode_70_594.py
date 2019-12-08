def climbStairs(n):
    if n == 1:
        return 1
    res = [-1 for i in range(n)]
    res[0], res[1] = 1, 2
    return dp(n-1, res)


def dp(n, res):
    if res[n] == -1:
        res[n] = dp(n-1, res) + dp(n-1, res)
    return res[n]


print(climbStairs(8))
