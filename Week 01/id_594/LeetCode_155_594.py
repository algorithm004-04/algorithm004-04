class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, x):
        self.stack.append([x])
        if (len(self.min_stack)) or (x <= self.min_stack[-1]):
            self.min_stack.append(x)

    def pop(self):
        if self.stack is None:
            return None
        elif self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
            self.stack.pop()
        else:
            self.stack.pop()

    def top(self):
        return self.stack[1]

    def getMin(self):
        return self.min_stack[-1]


