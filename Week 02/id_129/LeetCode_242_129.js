//有效字母异位词
/**
 * @param {string[]} strs
 * @return {string[][]}
 * 方法1：暴力法
 * 1.将数组里的每个单词都排序,排序时需要先将字符串打散成数组才能调用数组的sort方法
 * 2.生成map结构，key-Array
 * 
 */
var groupAnagrams = function (strs) {
  const sortFn = (a, b) => a.localeCompare(b)
  const map = new Map()
  strs.forEach(v => {
    let sortStr = v.split('').sort(sortFn).join('')
    if (!map.has(sortStr)) map.set(sortStr, [])
    map.get(sortStr).push(v)
  })
  return [...map.values()]
};

/**
 * 方法二：利用数学设计键
 * 算数基本定理：又称为正整数的唯一分解定理，
 * 即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，
 * 而且这些质因子按大小排列之后，写法仅有一种方式。
 * 1.用一个数组存储质数
 *  prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]。
 * 2.然后每个字符串的字符减去 ' a ' ，然后取到 prime 中对应的质数。把它们累乘。
 * 3.例如 abc ，就对应 'a' - 'a'， 'b' - 'a'， 'c' - 'a'，(Unicode码相减)即 0, 1, 2，
 *  也就是对应素数（prime数组） 2 3 5，然后相乘 2 * 3 * 5 = 30，就把 "abc" 映射到了 30。
 */
var groupAnagrams = function (strs) {
  const aCode = 'a'.charCodeAt(0)
  const prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]
  const map = new Map()
  for (let i = 0, l = strs.length; i < l; i++) {
    let str = strs[i]
    let mapKey = str.split('').reduce((pre, cur) => {
      return pre * prime[cur.charCodeAt(0) - aCode]
    }, 1)
    if (map.has(mapKey)) {
      map.get(mapKey).push(str)
    } else {
      map.set(mapKey, [str])
    }
  }
  return [...map.values()]
};


/**
 * 方法三：按计数分类
 * 首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。
 * 这样的话，"abb" 就映射到了 "1#2#0#0#0"。
 * "cdc" 就映射到了 "0#0#2#1#0"。
 * "dcc" 就映射到了 "0#0#2#1#0"。
 */
var groupAnagrams = function (strs) {
  const aCode = 'a'.charCodeAt(0)
  const map = new Map()
  for (let i = 0, l = strs.length; i < l; i++) {
    let str = strs[i]
    let mapKey = new Array(26).fill(0)
    for (let j = 0, k = str.length; j < k; j++) {
      mapKey[str[j].charCodeAt(0) - aCode]++
    }
    mapKey = mapKey.join('#')
    if (map.has(mapKey)) {
      map.get(mapKey).push(str)
    } else {
      map.set(mapKey, [str])
    }
  }
  return [...map.values()]
};
