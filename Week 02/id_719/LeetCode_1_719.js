/**
 * 
HashMap方法
    思路
        找hashmap 中对应的值是否存在
    伪代码
        遍历数组，存入hashmap(key: nums[i], value: i )
        遍历数组，target - nums[i], 如果在Hashmap中拿出， 返回
 */

var twoSum = function(nums, target) {
    let hashmap = Object.create(null)
    for (let i = 0; i < nums.length; i++) {
        hashmap[nums[i]] = i
    }
    // can get the hashmap

    for (let i = 0; i < nums.length; i++) {
        let temp = target - nums[i]
        if (hashmap[temp] && hashmap[temp] !== i) {
            return [i, hashmap[temp]]
        }
    }
    return null
}

console.log(twoSum([2, 7, 11, 15], 9))