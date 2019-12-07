/**
 * 
排序数组分类
    思路
        将数组的每一项排序，比如："eat" 就是 "aet"
        建立一个HashMap, key是“aet”， value是一个数组，里面含有 “eat"
        依次将数组的每一项放到hashmap中
        最后将hashmap的value,放回result
    伪代码
        for loop string in arr
        get the sorted_string
        sorted_string as key, string as the [value]
        (finally  for loop get a hashmap: {"aet": ["ate","eat","tea"], ...})

        for loop key in hashmap
        hashmap[key]: push this into the result
        (for loop get the result)

        return result
 */


const groupAnagrams = function(strs) {
    let hashmap = Object.create(null);
    for (let string of strs) {
        let sorted_string = string
            .split("")
            .sort((a, b) => {
                if (a < b) return -1;
                else if (a > b) return 1;
                else return 0;
            })
            .join("");
        if (!hashmap[sorted_string]) {
            hashmap[sorted_string] = new Array();
        }
        hashmap[sorted_string].push(string);
    }

    return Object.values(hashmap);
};


/**
 * 
按计数分类
    思路
        与242题相似，将"eat"等每一个string转换为一个[含字母个数的数组，下标是字母对应位置]，这个作为hashmap的key，value就是相同的key放在一起

    伪代码
        for loop string in array
        set a new array, with 26's 0
        for loop the string, to count char
        array[char_index] + 1
        (for loop get the array[3, 2, 0, 0, ...])
        hashmap([3, 2, 0, 0,...]) = string
        (for loop get the hashmap(key : same count of string))

        return object.values
 */

const groupAnagrams = function(strs) {
    let hashmap = Object.create(null);
    for (let string of strs) {
        let temp = new Array(26).fill(0);
        for (let s of string) {
            temp[s.charCodeAt(0) - "a".charCodeAt(0)] += 1;
        }
        if (!hashmap[temp]) {
            hashmap[temp] = new Array();
        }
        hashmap[temp].push(string);
    }

    return Object.values(hashmap);
};
