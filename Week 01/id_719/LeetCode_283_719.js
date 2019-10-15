/**
 * 方法：指针i与j
 *   j指向0（除非i与j相同）
 *   i循环，当非0时，与j的指向值交换
 */

var moveZeroes = function(nums) {
    let j = 0;
    let { length } = nums;

    for (let i = 0; i < length; i++) {
        // 交换条件
        if (nums[i] !== 0) {
            nums[j] = nums[i];
            if (i !== j) {
                nums[i] = 0;
            }
            j++;
        }
    }
};