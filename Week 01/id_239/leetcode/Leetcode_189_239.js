/**
 * leetcode: https://leetcode-cn.com/problems/rotate-array/
 *
 */

//方法1：通过移动改变索引，然后把对应的值存到新的数组的指定索引上即可。
var rotate = function(nums, k) {
    let arr = [];
    for (let i = 0; i< nums.length; i++) {
        let sum = i + k;
        if (sum < nums.length) {
            arr[sum] = nums[i];
        } else {
            arr[(sum - nums.length) % nums.length ] = nums[i];
        }
    }
    for (let i = 0; i < arr.length; i++) {
        nums[i] = arr[i];
    }
    return nums;
};
