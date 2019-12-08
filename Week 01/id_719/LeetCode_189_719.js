/**
 * @param {number[]} nums
 * @return {number}
 */


// 方法1： 建新数组（不符合规则）
var rotate1 = function(nums, k) {
    let {length} = nums
    let result = new Array(length)
    for (let i = 0; i < length; i++) {
        if (i + k >= length) {
            result[(i + k) - length] = nums[i]
        } else {
            result[i + k] = nums[i]
        }
    }
    return result
};


// 方法2 暴力：
var rotate2 = function(nums, k) {
    let temp, previous;
    for (let i = 0; i < k; i++) {
        previous = nums[nums.length - 1]
        for (let j = 0; j < nums.length; j++) {
            temp = nums[j]
            nums[j] = previous
            previous = temp
        }
    }
};

