/**
 *
 * leetcode地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * */


//暴力方法1

//思路：遍历数组，遇到当前元素和上一个元素相等的元素时，就把当前元素删除即可。
// var removeDuplicates = function(nums) {
//     for (let i = 1; i < nums.length; i++) {
//         if (nums[i] === nums[i - 1]) {
//             nums.splice(i, 1);
//             i--;
//         }
//     }
//     return nums.length;
// };


//双指针或者快慢指针，
var removeDuplicates = function(nums) {
    let i = 0;
    for (let j = 1; j < nums.length; j++) {
        if (nums[j] !== nums[i]) {
            i++;
            nums[i] = nums[j];        }
    }
    return i + 1;
};
