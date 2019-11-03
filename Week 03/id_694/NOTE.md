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

第9课课后作业

- [ ] https://leetcode-cn.com/problems/word-ladder/description/  127
- [ ] https://leetcode-cn.com/problems/word-ladder-ii/description/  126
- [ ] https://leetcode-cn.com/problems/number-of-islands/  200
- [ ] https://leetcode-cn.com/problems/minesweeper/description/  529

第10课课后作业

- [x] https://leetcode-cn.com/problems/lemonade-change/description/  860
- [x] https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/  122
- [x] https://leetcode-cn.com/problems/assign-cookies/description/  455
- [ ] https://leetcode-cn.com/problems/walking-robot-simulation/description/  874
- [x] https://leetcode-cn.com/problems/jump-game/  55
- [x] https://leetcode-cn.com/problems/jump-game-ii/  45

第11课课后作业

- [x] https://leetcode-cn.com/problems/search-in-rotated-sorted-array/  33
- [x] https://leetcode-cn.com/problems/search-a-2d-matrix/   74
- [x] https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/  153
