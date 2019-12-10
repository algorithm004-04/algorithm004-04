/**
 * 
数组排序后比较差异
思路
    数组排序后比较差异
伪代码
    s and t convert to the array
    sort the sArr and tArr
    compare sArr and tArr
 */

var isAnagram = function(s, t) {
    const s_sorted = s.split('').sort((a, b) => {
        if (a < b) return -1
        else if (a > b) return 1
        else return 0
    }).join('')

    const t_sorted = t.split('').sort((a, b) => {
        if (a < b) return -1
        else if (a > b) return 1
        else return 0
    }).join('')

    return s_sorted === t_sorted
};



 /**
  * 
手动模拟hashtable
    思路
        手动模拟hashtable, 将字符串“a-z"的ASCII码作key, 计数求差异
    伪代码
        create two arrays
        arr1: 26 poistions with value 0
        arr2: 26 positions with value 0
        for loop arr1
        put the character into the array index with the correct index of 26
        count the number of character
        for loop arr2
        the same as arr1 before

        compare the arr1 and arr2, if equals return true otherwise return false
  */

 var isAnagram = function(s, t) {
    let arr1 = new Array(26).fill(0),
        arr2 = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        arr1[s.charCodeAt(i) - "a".charCodeAt(0)] += 1;
    }
    for (let i = 0; i < t.length; i++) {
        arr2[t.charCodeAt(i) - "a".charCodeAt(0)] += 1;
    }
    // 比较arr1 与 arr2是否相等
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] !== arr2[i]) {
            return false;
        }
    }
    return true;
};

/**
 * 
Map 计数
    思路
        用hashmap 计数，对比计数差异
    伪代码
        create two maps (map1, map2)
        for loop param s and t
        if the map has the character, plus the value with 1 else eqaul to 1

        compare two maps
 */


var isAnagram = function(s, t) {
    let m1 = Object.create(null);
    let m2 = Object.create(null);

    for (let letter of s) {
        m1[letter] ? (m1[letter] += 1) : (m1[letter] = 1);
    }
    for (let letter of t) {
        m2[letter] ? (m2[letter] += 1) : (m2[letter] = 1);
    }
    
    // 也可以写一个object比较函数
    for (let key in m1) {
        if (m2[key] === m1[key]) {
            delete m2[key];
            delete m1[key];
        }
    }

    return Object.keys(m2).length === 0 && Object.keys(m1).length === 0;
}