/**
 * 旋转数组
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 * 方法一：从末尾的元素开始出栈，出K个，依次插入头部
 */
var rotate = function (nums, k) {
    while (k > 0) {
        nums.shift(nums.pop())
        k--;
    }
};
/**
 * 方法二：1.旋转数组K次;2.旋转头部k个元素;3.旋转n-k个元素
 */
var rotate = function (nums, k) {
    const l = nums.length
    k %= l
    reverse(nums, 0, l - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, l - 1)
    function reverse(nums, i, j) {
        while (i < j) {
            [nums[i], nums[j]] = [nums[j], nums[i]]
            i++;
            j--;
        }
    }
};
// 暴力解法
var rotate = function (nums, k) {
    var n = nums.length;
    var tmpEnd = 0;
    var tmpPrev = 0;
    for (var i = 0; i < k; i++) {
        tmpEnd = nums[n - 1];
        for (var r = 0; r < n; r++) {
            tmpPrev = nums[r];
            nums[r] = tmpEnd;
            tmpEnd = tmpPrev;
        }
    }
};
