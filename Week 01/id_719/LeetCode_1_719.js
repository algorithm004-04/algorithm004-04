var twoSum = function(nums, target) {
    let map = {};
    for (let i = 0; i < nums.length; i++) {
        map[nums[i]] = i;
    }
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (map[complement] && map[complement] != i) {
            return [i, map[complement]];
        }
    }
};