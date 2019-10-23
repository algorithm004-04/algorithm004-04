# NOTE

  

## 递归思维的要点：
1. 抵制人肉递归
2. 找到最近重复性
3. 数学归纳法思维

### 递归函数模版

```
def recursion(level, param, ...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        retrun
    
    # process logic in current level

    # drill down
    self.recursion(level + 1, param, ...)

    # reverse the current level status if needed
```