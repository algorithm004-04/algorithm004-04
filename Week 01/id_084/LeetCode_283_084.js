/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

//  方法一
var moveZeroesOne = function(nums) {
  let j = 0;
  for (let i = 0; i < nums.length; i++) {
      if (nums[i] !== 0) {
          nums[j] = nums[i];
          if (i !== j) {
              nums[i] = 0
          }
          j++
      }
  }
};

// 方法二
// 找出等于 0 的元素， 并剔除出数组
// 剔除掉的元素下标被后面一个元素补上
// 所以需要将下标 i-- ，在返回判断补上的元素是否为0
// 每剔除一个 0 元素 zeroNums++
// 最后有多少个 0 就补多少个0
var moveZeroesTwo = function(nums) {
  let zeroNums = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            nums.splice(i, 1);
            i--;
            console.log(nums)
            zeroNums++
        }
    }
    while(zeroNums > 0) {
        nums.push(0);
        zeroNums--;
    }
    console.log(nums)
};
