/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

 // 方法一
var rotate = function (nums, k) {
    k = k % nums.length;
    nums.reverse();
    rervse(nums, 0, k - 1);
    rervse(nums, k, nums.length - 1);
};
function rervse (arr, start, end) {
    while (start < end) {
        var temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

// 方法二

var rotate2 = function (nums, k) {
    k = k % nums.length;
    nums.unshift.apply(nums, nums.splice(nums.length - k, k));
};

