def generateParenthesis1(n: int):
    res = []
    recursive("", 0, 0, n, res)
    return res


def recursive(s, left, right, n, res):
    if (left == n) and (right == n):
        res.append(s)
        return res

    if left > right:
        recursive(s+")", left, right+1, n, res)

    if left < n:
        recursive(s+"(", left+1, right, n, res)


def generateParenthesis2(n: int):
    def recursive(s, left, right, res=[]):          # 精妙的组员啊，直接在里面设置了res=[]了，在最后的return返回了
        if left:
            recursive(s+"(", left-1, right)
        if left < right:
            recursive(s+")", left, right-1)
        if not right:
            res += s
        return res
    return recursive("", n, n)


def generateParenthesis3(n: int):           # 好像是把递归的形式用迭代写了出来？
    if n == 0:
        return None
    res = []
    res.append([None])
    res.append(["()"])
    for i in range(2, n+1):
        stack = []
        for j in range(i):
            temp_1 = res[j]
            temp_2 = res[i-1-j]
            for k1 in temp_1:
                for k2 in temp_2:
                    if k1 == None:
                        k1 = ""
                    if k2 == None:
                        k2 = ""
                    cur = "(" + k1 + ")" + k2
                    stack.append(cur)
        res.append(stack)
    return res[n]


ex = 3
print(generateParenthesis3(ex))
