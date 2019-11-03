# NOTE

## 二分查找

三个条件：

1. 单调性
2. 存在上下边界
3. 可以索引访问

模板：

```python
left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right) / 2
    if array[mid] == target:
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```
