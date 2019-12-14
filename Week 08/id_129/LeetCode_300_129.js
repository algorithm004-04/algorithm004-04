/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
  var lis = [];
  for (var i = 0; i < nums.length; i++) {
    lis.push(1);
    for (var j = 0; j < i; j++) {
      if (nums[j] < nums[i]) lis[i] = Math.max(lis[i], lis[j] + 1);
    }
  }
  return nums.length ? Math.max.apply(null, lis) : 0;
};