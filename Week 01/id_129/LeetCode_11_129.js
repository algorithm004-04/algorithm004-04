/**
 * @param {number[]} height
 * @return {number}
 * 容器最多盛水
 * 方法一：双层循环，迭代更新面积最大值
 */
var maxArea = function (height) {
  let l = height.length
  let maxArea = 0
  for (let i = 0; i < l; i++) {
    for (let j = i + 1; j < l; j++) {
      minH = Math.min(height[i], height[j])
      maxArea = Math.max(maxArea, minH * (j - i))
    }
  }
  return maxArea
};

var maxArea = function (height) {
  let l = height.length
  let maxArea = 0
  for (let i = 0, j = l - 1; i < j;) {
    maxH = height[i] < height[j] ? height[i++] : height[j--]
    maxArea = Math.max(maxArea, maxH * (j - i + 1)) //j-(i-1) 或 j+1-i
  }
  return maxArea
};
