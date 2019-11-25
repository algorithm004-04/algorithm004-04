# NOTE

## 贪心算法Greedy

算法特点:

在每一步选择中都采取在当前状态下最优解，从而希望结果是全局最好或最优的算法
最优子结构: 问题能够分解为子问题且其最优解能递推到最终最优解

## 动态规划

相同: 都使用问题分解并用递归解决问题
不同: 动态规划会保存中间结果集，并对结果集进行选择，可以回退，因此可以达到全局最优；
贪心不可回退，一路走到"黑"，因此仅在特定场景能够达到全局最优

## 二分查找

算法特点:

目标函数单调性(单调递增或者递减)
存在上下边界
通过索引访问

算法模版:
```
   left = 0
   right = 0
   while left <= right:
      mid = (left + right) / 2  
      if array[mid] == target:
         # find the target!!
         break or return result
      elif array[mid] < target:
         left = mid + 1
      else:
   right = mid - 1
```
