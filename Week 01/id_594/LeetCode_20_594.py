def isValid(s):
    _dict = {'(': ')', '[': ']', '{': '}', '1': 1}      # 这里的'1'：1为的是防止栈空，在elif时，pop的时候出错
    stack = ['1']
    for i in s:
        if i in _dict:
            stack.append(i)                  # 将左括号压入栈
        elif _dict[stack.pop()] != i:
            return False
    return len(stack) == 1


ex = '()))'
print(isValid(ex))
