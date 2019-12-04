/**
 * @param {number[]} nums
 * @return {number}
 */
// 方法一
var removeDuplicates = function(nums) {
    var i, j, current;
    for( i = 0; i < nums.length; i++) {
        current = nums[i];
        for (j = nums.length - 1; j > i; j--) {
            if (current === nums[j]) {
                nums.splice(j, 1);
            }
        }
    }
    return nums.length;
};
// 方法二
var removeDuplicates2 = function(nums) {
    var i = 0;
    for (var j = 1; j < nums.length; j++) {
        if (nums[j] !== nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    nums.splice(i, nums.length - i - 1);
    return nums.length;
}

